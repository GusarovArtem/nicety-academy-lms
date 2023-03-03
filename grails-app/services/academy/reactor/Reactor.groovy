package academy.reactor

import academy.persist.event.EntityChangedEvent
import academy.reactor.config.DelegatesToReactorConfigurer
import academy.reactor.config.ReactorConfig
import groovy.util.logging.Slf4j
import org.grails.datastore.gorm.GormEntity

@Slf4j
abstract class Reactor implements ReactorConfigTrait {

    def <T extends GormEntity> void on(Class<T> clazz,
                                       @DelegatesToReactorConfigurer Closure... config) {
        onWithInitialConfig(ReactorConfig.of(clazz, domainService.allPersistentProperties(clazz)), config)
    }

    boolean notify(List<EntityChangedEvent> changes) {
        def (config, matchingEvent) = configs.findResult { c ->
            def matchingEvent = changes.find { c.matches(it) }
            matchingEvent ? [c, matchingEvent] : null
        } ?: [null, null]

        if (config) {
            log.info("REACTOR ${this.class.simpleName} fired:\n\t${matchingEvent}\n\t${config}")
            def entity = matchingEvent.entity
            def closure = config.reactClosure
            closure.delegate = entity
            closure(matchingEvent)
            return true
        }

        false
    }


}

