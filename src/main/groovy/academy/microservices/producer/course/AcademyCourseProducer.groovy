package academy.microservices.producer.course

import academy.product.course.AcademyCourse
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic


@KafkaClient
interface AcademyCourseProducer {

    @Topic('createCourse')
    AcademyCourse createCourse(AcademyCourse course)

    @Topic('updateCourse')
    AcademyCourse updateCourse(AcademyCourse course)

}

