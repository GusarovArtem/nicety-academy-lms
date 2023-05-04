package academy.reactor.config.impl

import groovy.transform.AnnotationCollector

@DelegatesTo(type = "academy.reactor.config.ReactorConfigurer<academy.course.Course>")
@AnnotationCollector
@interface DelegatesToCourseReactorConfigurer {}
