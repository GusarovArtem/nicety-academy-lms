package academy.domain.reactor.impls.microservices


import academy.communication.kafka.produce.course.CourseProducer
import academy.product.course.Course
import org.springframework.beans.factory.annotation.Autowired


class CourseProducerReactorService extends academy.domain.reactor.Reactor {

    @Autowired
    CourseProducer courseProducer

    @Override
    void configure() {
        on Course, {
            types academy.util.change.ChangeType.CREATED

            react {
                courseProducer.createCourse(it.entity)
            }
        }
        on Course, {
            types academy.util.change.ChangeType.UPDATED

            react {
                courseProducer.updateCourse(it)
            }
        }
    }

}
