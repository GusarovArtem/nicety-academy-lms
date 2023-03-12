package academy.kafka.producer.course


import academy.product.course.AcademyCourseType
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface AcademyCourseTypeProducer {

    @Topic('createCourseType')
    AcademyCourseType createCourseType(AcademyCourseType type)

}

