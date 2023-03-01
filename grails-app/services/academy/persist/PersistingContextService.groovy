package academy.persist

import grails.gorm.transactions.Transactional
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString

import javax.annotation.PostConstruct

class PersistingContextService {

    def domainService

    def reactorsExecutionService

    private ThreadLocal<Persister> persistingContext

    @PostConstruct
    def init() {
        persistingContext = ThreadLocal.<Persister> withInitial { new Persister(domainService: domainService) }
    }

    @Transactional
    <T> T within(@ClosureParams(value = FromString, options = "academy.persist.Persister") Closure<T> closure) {
        final persister = persistingContext.get()
        try {
            final closureResult = persister.within(closure)
            if (persister.rootFinished() && persister.hasChanges()) {
                reactorsExecutionService.executeForPersister(persister)
            }
            closureResult
        } finally {
            if (persister.rootFinished()) {
                persistingContext.remove()
            }
        }
    }

}
