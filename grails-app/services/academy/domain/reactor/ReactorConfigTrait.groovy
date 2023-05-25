package academy.domain.reactor

import academy.domain.DomainService
import academy.domain.reactor.config.ReactorConfig
import academy.domain.reactor.config.ReactorConfigurer
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
trait ReactorConfigTrait {

    @Autowired
    DomainService domainService

    List<ReactorConfig> configs = []

    void onWithInitialConfig(ReactorConfig initialConfig,
                             Closure... config) {
        def configurer = new ReactorConfigurer(config: initialConfig)
        config.each {
            it.delegate = configurer
            it()
        }
        configs << configurer.result()
    }

    def clearConfiguration() {
        configs = []
    }

    abstract void configure()

}

