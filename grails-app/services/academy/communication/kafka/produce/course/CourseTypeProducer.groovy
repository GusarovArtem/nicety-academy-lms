package academy.communication.kafka.produce.course


import academy.product.course.CourseType
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface CourseTypeProducer {

    @Topic('createCourseType')
    CourseType createCourseType(CourseType type)

}

