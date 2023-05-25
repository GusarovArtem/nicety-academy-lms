package academy.domain.persist.impl

import academy.domain.DomainService
import academy.util.change.ChangeSource
import academy.persist.PersistOptions
import academy.util.entity.EntityChangedEvent
import groovy.lang.DelegatesTo.Target
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString
import groovy.util.logging.Slf4j
import org.grails.datastore.gorm.GormEntity

import static academy.util.change.ChangeType.*
import static academy.util.property.Closures.delegate

@Slf4j
trait PersisterPersistingTrait {

    def <T extends GormEntity> T persistInternal(@Target T entity,
                                                 Class<T> entityClass,
                                                 PersistOptions persistOptions = new PersistOptions(),
                                                 @DelegatesTo(strategy = Closure.DELEGATE_FIRST)
                                                 @ClosureParams(value = FromString, options = "T") Closure closure) {
        def toBePersisted = entity ?: entityClass.newInstance()
        boolean isNew = toBePersisted.id == null

        delegate(toBePersisted, closure)

        if (isNew) {
            addChange(createdEvent(toBePersisted, entityClass, persistOptions.changeSource))
            updateOwners(toBePersisted, entityClass, CREATED, persistOptions.changeSource)
        } else if (toBePersisted.isDirty()) {
            addChange(updatedEvent(toBePersisted, entityClass, persistOptions.changeSource, toBePersisted.getDirtyPropertyNames()))
            updateOwners(toBePersisted, entityClass, UPDATED, persistOptions.changeSource)
        }

        if (!persistOptions.noSaveCall) toBePersisted.save()

        toBePersisted
    }

    def <T extends GormEntity> void deleteInternal(T entity, PersistOptions persistOptions = new PersistOptions()) {
        def entityClass = domainService().entityClass(entity)

        addChange(deletedEvent(entity, entityClass, persistOptions.changeSource))
        updateOwners(entity, entityClass, DELETED, persistOptions.changeSource)

        entity.delete()
    }

    abstract DomainService domainService()

    abstract addChange(EntityChangedEvent event)

    private updateOwners(entity, Class type, academy.util.change.ChangeType changeType, ChangeSource changeSource) {
        domainService().ownersAssociations(type).each { childAssociation ->
            def owningEntity = entity."${childAssociation.referencedPropertyName}"
            if (owningEntity) {
                if (changeType == CREATED) {
                    domainService().addToOwnerAssociationIfNecessary(entity, childAssociation)
                } else if (changeType == DELETED) {
                    domainService().removeFromOwnerAssociationIfNecessary(entity, childAssociation)
                }
                addChange(updatedEvent(owningEntity,
                                       childAssociation.owner.javaClass,
                                       changeSource,
                                       [childAssociation.name]))
            }
        }
    }

    private createdEvent(source, sourceClass, ChangeSource changeSource) {
        new EntityChangedEvent(entity: source,
                               entityClass: sourceClass,
                               type: CREATED,
                               source: changeSource,
                               changedProps: domainService().allPersistentProperties(sourceClass))
    }

    private updatedEvent(source, sourceClass, ChangeSource changeSource, changedProps) {
        new EntityChangedEvent(entity: source,
                               entityClass: sourceClass,
                               type: UPDATED,
                               source: changeSource,
                               changedProps: changedProps as Set)
    }

    private deletedEvent(source, sourceClass, ChangeSource changeSource) {
        new EntityChangedEvent(entity: source,
                               entityClass: sourceClass,
                               type: DELETED,
                               source: changeSource,
                               changedProps: domainService().allPersistentProperties(sourceClass))
    }

}