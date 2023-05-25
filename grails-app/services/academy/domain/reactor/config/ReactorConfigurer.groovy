package academy.domain.reactor.config


import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString
import org.grails.datastore.gorm.GormEntity

import static academy.util.property.Closures.collectProps
import static academy.util.entity.Entities.oldValue

class ReactorConfigurer<T extends GormEntity> {

    private ReactorConfig<T> config

    def source(academy.util.change.ChangeSource... sources) {
        config.changeSources = sources as Set
    }

    def types(academy.util.change.ChangeType... types) {
        config.changeTypes = types as Set
    }

    def when(@DelegatesTo(type = "T") Closure<Boolean> when) {
        config.whens << when
    }

    def changed(@DelegatesTo(type = "T") Closure props) {
        config.onChangedProps = collectProps(config.entityClass, props)
    }

    def react(@ClosureParams(value = FromString, options = "academy.persist.event.EntityChangedEvent<T>")
              @DelegatesTo(type = "T") Closure react) {
        config.reactClosure = config.reactClosure ? config.reactClosure >> react : react
    }

    def <R> R old(@DelegatesTo(type = "T") Closure<R> old) {
        // we assume old is called from within "when" or "react"'s closure
        (R) oldValue((T) old.owner.delegate, (collectProps(config.entityClass, old).last()))
    }

    ReactorConfig result() {
        if (!config.reactClosure) throw new IllegalStateException("No react closure...")
        config
    }

}
