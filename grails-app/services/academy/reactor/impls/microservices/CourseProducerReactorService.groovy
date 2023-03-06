package academy.reactor.impls.microservices

import academy.course.AcademyCourse
import academy.microservices.producer.course.AcademyCourseProducer
import academy.persist.change.ChangeType
import academy.reactor.Reactor
import org.springframework.beans.factory.annotation.Autowired


class CourseProducerReactorService extends Reactor {

    @Autowired
    AcademyCourseProducer courseProducer

    @Override
    void configure() {
        on AcademyCourse, {
            types ChangeType.CREATED

            react {
                courseProducer.createCourse(it.entity)
            }
        }
        on AcademyCourse, {
            types ChangeType.UPDATED

            react {
                courseProducer.updateCourse(it)
            }
        }
    }

}
