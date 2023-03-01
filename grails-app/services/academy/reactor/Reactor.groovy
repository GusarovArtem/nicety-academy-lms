package academy.reactor

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

}

