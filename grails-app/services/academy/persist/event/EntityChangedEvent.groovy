package academy.persist.event

import academy.persist.change.ChangeSource
import academy.persist.change.ChangeType
import org.grails.datastore.gorm.GormEntity

class EntityChangedEvent<T extends GormEntity> {

    ChangeSource source

    ChangeType type

    Class<T> entityClass

    T entity

    Set<String> changedProps

    static EntityChangedEvent copy(EntityChangedEvent otherEvent) {
        new EntityChangedEvent(source: otherEvent.source,
                               type: otherEvent.type,
                               entityClass: otherEvent.entityClass,
                               entity: otherEvent.entity,
                               changedProps: otherEvent.changedProps)
    }

    boolean differs(EntityChangedEvent other) {
        entityClass != other.entityClass ||
        source != other.source ||
        type != other.type ||
        entity.id == null ||
        other.entity.id == null ||
        entity.id != other.entity.id ||
        changedProps != other.changedProps
    }

    private String identity = UUID.randomUUID().toString()

    String groupIdentity() {
        if (entity.id) {
            "$entityClass.name $entity.id"
        } else {
            identity
        }
    }

    @Override
    String toString() {
        "$type $entityClass.name (by $source), $entity, $changedProps"
    }

}
