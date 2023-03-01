package academy.reactor.config

import groovy.transform.AnnotationCollector

@DelegatesTo(type = "academy.reactor.config.ReactorConfigurer<T>")
@AnnotationCollector
@interface DelegatesToReactorConfigurer {}
