package academy.reactor

import academy.persist.Persister
import academy.utils.Collections
import com.google.common.collect.MultimapBuilder
import com.google.common.collect.SetMultimap
import groovy.util.logging.Slf4j

@Slf4j
class ReactorsExecutionService  {

    def reactorsRegistrarService

    // complicated as hell - sorry to whoever maintains that ;)
    def executeForPersister(Persister persister) {
        def event = persister.flush()

        log.info "CHANGE EVENT - $event"

        def reactors = reactorsRegistrarService.reactors()

        def changes = event.changes

        SetMultimap<String, Reactor> executions =
                MultimapBuilder.hashKeys().hashSetValues().<String, Reactor> build()

        def currentChangeIdx = 0
        Collections.loop {
            def currentChange = changes[currentChangeIdx]
            currentChangeIdx++

            def currentReactorIdx = 0
            Collections.loop {
                def currentReactor = reactors[currentReactorIdx]
                currentReactorIdx++

                if (!executions.containsEntry(currentChange.groupIdentity(), currentReactor)) {
                    // Reactors can modify persister (and thus changes !!!)
                    def reacted = persister.within({ currentReactor.notify([currentChange]) })
                    if (reacted) {
                        if (persister.changed) {
                            log.info "REACTOR ${currentReactor.class.simpleName} persisted new changes"
                            def newEvent = persister.flush()

                            log.info "changed CHANGE EVENT - $newEvent"

                            changes = newEvent.changes
                            currentChangeIdx = 0
                        }
                        executions.put(currentChange.groupIdentity(), currentReactor)
                    }
                }
            } until { currentReactorIdx == reactors.size() }
        } until { currentChangeIdx == changes.size() }
    }

}
