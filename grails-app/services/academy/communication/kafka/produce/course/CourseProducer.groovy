package academy.communication.kafka.produce.course


import academy.product.course.Course
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic


@KafkaClient
interface CourseProducer {

    @Topic('createCourse')
    Course createCourse(Course course)

    @Topic('updateCourse')
    Course updateCourse(Course course)

}

