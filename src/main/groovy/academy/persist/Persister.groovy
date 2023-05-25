package academy.persist

import academy.domain.DomainService
import groovy.util.logging.Slf4j

import javax.annotation.concurrent.NotThreadSafe

import static academy.util.construct.Collections.notEmpty

@Slf4j
@NotThreadSafe
class Persister implements academy.domain.persist.impl.PersisterPersistingTrait {

    private DomainService domainService

    private List<academy.util.entity.EntityChangedEvent> changes = []

    private long nestLevel = 0

    def changed = false

    def <T> T within(Closure<T> closure) {
        changed = false
        def existingEvent = forgeEvent()
        try {
            nestLevel++
            def closureResult = this.with closure
            changed = forgeEvent().differs(existingEvent)
            closureResult
        } finally {
            nestLevel--
        }
    }

    boolean rootFinished() {
        nestLevel == 0
    }

    boolean hasChanges() {
        notEmpty changes
    }

    def flush() {
        changes = academy.util.change.ChangesSquasher.squashedChanges(changes)
        forgeEvent()
    }

    private academy.util.entity.EntitiesChangedEvent forgeEvent() {
        new academy.util.entity.EntitiesChangedEvent(changes: changes)
    }

    @Override
    DomainService domainService() {
        domainService
    }

    @Override
    def addChange(academy.util.entity.EntityChangedEvent event) {
        changes << event
    }

}