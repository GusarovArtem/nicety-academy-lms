package academy.domain.persist

import academy.domain.DomainService
import academy.persist.PersistOptions
import academy.persist.Persister
import academy.util.change.exception.InvalidChangeException
import groovy.lang.DelegatesTo.Target
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString
import groovy.util.logging.Slf4j
import org.grails.datastore.gorm.GormEntity
import org.springframework.beans.factory.annotation.Autowired

import static com.google.common.base.Preconditions.checkNotNull

@Slf4j
trait PersistingTrait {

    @Autowired
    PersistingContextService persistingContextService

    @Autowired
    DomainService domainService

    def <T extends GormEntity> T persist(@Target T entity,
                                         PersistOptions persistOptions = new PersistOptions(),
                                         @DelegatesTo(strategy = Closure.DELEGATE_FIRST)
                                         @ClosureParams(value = FromString, options = "T") Closure closure) {
        checkNotNull(entity)
        persist(persistOptions) {
            persistInternal(entity, domainService.entityClass(entity), persistOptions, closure)
        }
    }

    def <T extends GormEntity> T persistNew(@Target Class<T> entityClass,
                                            PersistOptions persistOptions = new PersistOptions(),
                                            @DelegatesTo(genericTypeIndex = 0, strategy = Closure.DELEGATE_FIRST)
                                         @ClosureParams(value = FromString, options = "T") Closure closure) {
        persist(persistOptions) {
            persistInternal(null, entityClass, persistOptions, closure)
        }
    }

    def <T extends GormEntity> T persist(@Target T entity,
                                         Class<T> entityClass,
                                         PersistOptions persistOptions = new PersistOptions(),
                                         @DelegatesTo(strategy = Closure.DELEGATE_FIRST)
                                         @ClosureParams(value = FromString, options = "T") Closure closure) {
        persist(persistOptions) {
            persistInternal(entity, entityClass, persistOptions, closure)
        }
    }

    def <T extends GormEntity> void delete(T entity,
                                           PersistOptions persistOptions = new PersistOptions()) {
        checkNotNull(entity)
        persist(persistOptions) {
            deleteInternal(entity, persistOptions)
        }
    }

    def <T> T persist(PersistOptions persistOptions = new PersistOptions(),
                      @DelegatesTo(value = Persister, strategy = Closure.DELEGATE_FIRST) Closure<T> closure) {
        try {
            persistingContextService.within closure
        } catch (InvalidChangeException ice) {
            if (persistOptions.logAndIgnoreInvalidChanges) {
                log.warn "Ivalid entity change from event:\n\t${ice.changeEvent}", ice
                return null
            }
            throw ice
        }
    }

}
