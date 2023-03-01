package academy.reactor.config

import academy.persist.change.ChangeSource
import academy.persist.change.ChangeType
import academy.persist.event.EntityChangedEvent
import org.grails.datastore.gorm.GormEntity


class ReactorConfig<T extends GormEntity> {

    Class<T> entityClass

    Set<ChangeSource> changeSources

    Set<ChangeType> changeTypes

    List<Closure<Boolean>> whens

    Set<String> onChangedProps

    Closure reactClosure

    static of(Class entityClass, Set<String> onChangedProps) {
        of(entityClass, ChangeType.all(), onChangedProps)
    }

    static of(Class entityClass, Collection<ChangeType> changeTypes, Set<String> onChangedProps) {
        new ReactorConfig(entityClass: entityClass,
                changeSources: ChangeSource.all(),
                changeTypes: changeTypes as Set,
                whens: [],
                onChangedProps: onChangedProps)
    }

    boolean matches(EntityChangedEvent event) {
        entityClass.isAssignableFrom(event.entityClass) &&
        changeSources.contains(event.source) &&
        changeTypes.contains(event.type) &&
        !onChangedProps.disjoint(event.changedProps) &&
        whens.every { event.entity.with(it) }
    }

    @Override
    String toString() {
        "$entityClass.name, $changeSources, $changeTypes, $onChangedProps"
    }

}
