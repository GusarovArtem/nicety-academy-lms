package academy.domain.reactor.config.impl

import groovy.transform.AnnotationCollector

@DelegatesTo(type = "academy.reactor.config.ReactorConfigurer<academy.course.CourseType>")
@AnnotationCollector
@interface DelegatesToCourseTypeReactorConfigurer {}
