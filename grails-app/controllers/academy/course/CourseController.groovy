package academy.course


import academy.product.course.Course
import academy.trait.ControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class CourseController implements ControllerTrait {

    @Override
    def targetDomainClass() {
        return Course
    }


    def index() {
        def courseInstanceList = targetDomainClass().findAll()

        render model: [courseInstanceClass: targetDomainClass(),
                       courseInstanceList : courseInstanceList], view: '/course/index'
    }

    def show(Course courseInstance) {
        courseInstance.clearErrors()
        render model: [courseInstance: courseInstance], view: '/course/show'
    }

    def create() {
        render model: [courseInstance: targetDomainClass()
                .newInstance(params)], view: '/course/create'
    }

    @Transactional
    def save(Course course) {
        if (!course) {
            notFound()
            return
        }

        course.clearErrors()
        course.validate()

        if (course.hasErrors()) {
            render model: [courseInstance: course], view: '/course/create'
            return
        }

        course = persistNew(Course) {
            tittle = course.tittle
            description = course.description
            createdOn = new Date()
            coursePrice = course.coursePrice
            courseType = course.courseType
            active = course.active
        }

        showMessage(course.tittle, "default.created.message")
        redirect course
    }


    def edit(Course course) {
        render model: [courseInstance: course], view: '/course/edit'
    }

    @Transactional
    def update(Course course) {
        if (course == null) {
            notFound()
            return
        }

        course.validate()

        if (course.hasErrors()) {
            render model: [courseInstance: course], view: '/course/edit'
            return
        }

        course = persist(course) {
            tittle = course.tittle
            description = course.description
            courseType = course.courseType
            active = course.active
        }

        showMessage(course.tittle, 'academyCourse.updated')
        redirect course

    }

}
