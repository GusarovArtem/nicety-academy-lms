package academy.domain.reactor.config


import org.grails.datastore.gorm.GormEntity


class ReactorConfig<T extends GormEntity> {

    Class<T> entityClass

    Set<academy.util.change.ChangeSource> changeSources

    Set<academy.util.change.ChangeType> changeTypes

    List<Closure<Boolean>> whens

    Set<String> onChangedProps

    Closure reactClosure

    static of(Class entityClass, Set<String> onChangedProps) {
        of(entityClass, academy.util.change.ChangeType.all(), onChangedProps)
    }

    static of(Class entityClass, Collection<academy.util.change.ChangeType> changeTypes, Set<String> onChangedProps) {
        new ReactorConfig(entityClass: entityClass,
                changeSources: academy.util.change.ChangeSource.all(),
                changeTypes: changeTypes as Set,
                whens: [],
                onChangedProps: onChangedProps)
    }

    boolean matches(academy.util.entity.EntityChangedEvent event) {
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
