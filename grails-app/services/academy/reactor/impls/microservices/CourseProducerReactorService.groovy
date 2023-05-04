package academy.reactor.impls.microservices


import academy.kafka.producer.course.CourseProducer
import academy.persist.change.ChangeType
import academy.product.course.Course
import academy.reactor.Reactor
import org.springframework.beans.factory.annotation.Autowired


class CourseProducerReactorService extends Reactor {

    @Autowired
    CourseProducer courseProducer

    @Override
    void configure() {
        on Course, {
            types ChangeType.CREATED

            react {
                courseProducer.createCourse(it.entity)
            }
        }
        on Course, {
            types ChangeType.UPDATED

            react {
                courseProducer.updateCourse(it)
            }
        }
    }

}
