package academy.persist.change

import academy.persist.event.EntityChangedEvent

import static ChangeType.CREATED
import static ChangeType.UPDATED

class ChangesSquasher {

    static List<EntityChangedEvent> squashedChanges(List<EntityChangedEvent> changes) {
        def squashedChanges = []
        squashedChanges.addAll(changes)

        removeUpdatedForSameCreated(squashedChanges)
        mergeOfSameType(squashedChanges)

        squashedChanges
    }

    private static removeUpdatedForSameCreated(List<EntityChangedEvent> changes) {
        def toRemove = changes.findAll { it.type == UPDATED }
                              .findAll { u ->
            changes.any {
                it.type == CREATED && it.entityClass == u.entityClass && it.source == u.source && it.entity?.id == u.entity.id
            }
        }
        changes.removeAll(toRemove)
    }

    private static mergeOfSameType(List<EntityChangedEvent> changes) {
        def toMerge = changes.findAll { it.type == UPDATED || it.entity.id }
                             .groupBy { u -> "$u.type $u.entityClass $u.source $u.entity.id" }
        toMerge.each {
            changes.removeAll(it.value)
            def mergedEvent = EntityChangedEvent.copy(it.value.first())
            mergedEvent.changedProps = it.value.collect { it.changedProps }.flatten() as Set<String>
            changes << mergedEvent
        }
        changes.removeAll(toMerge)
    }

}
