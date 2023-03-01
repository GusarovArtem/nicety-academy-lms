package academy.persist.event

import groovy.transform.Immutable

@Immutable
class EntitiesChangedEvent {

    List<EntityChangedEvent> changes

    boolean differs(EntitiesChangedEvent other) {
        changes.size() != other.changes.size() || changes.any { c1 -> other.changes.every { c2 -> c1.differs(c2) } }
    }

    @Override
    String toString() {
        "CHANGES:\n\t${changes.join('\n\t')}"
    }

}
