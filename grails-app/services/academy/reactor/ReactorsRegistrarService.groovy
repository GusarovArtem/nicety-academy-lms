package academy.reactor

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType
import org.springframework.beans.factory.annotation.Autowired

import javax.annotation.PostConstruct

class ReactorsRegistrarService {

    @Autowired
    private List<Reactor> reactors

    private List<Class<? extends Reactor>> runFirstReactors = []

    private List<Class<? extends Reactor>> runLastReactors = []

    @PostConstruct
    def init() {
        reactors.sort { r ->
            if (Reactor.isAssignableFrom(r.class)) {
                return -5
            }

            def runFirstIndex = runFirstReactors.findIndexOf { it.isAssignableFrom(r.class) }
            if (runFirstIndex != -1) {
                return runFirstIndex
            }

            def runLastIndex = runLastReactors.findIndexOf { it.isAssignableFrom(r.class) }
            if (runLastIndex != -1) {
                return runLastIndex + 1 + 100_000
            }

            100_000
        }
        reactors = reactors.asImmutable()
        log.info "Registered VALIDATORS/REACTORS:\n\t${reactors.join('\n\t')}"
    }

    def each(@ClosureParams(value = SimpleType, options = ["Reactor"]) Closure closure) {
        reactors.each closure
    }

}
