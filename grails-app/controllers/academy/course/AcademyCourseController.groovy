package academy.course

import academy.trait.AcademyControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class AcademyCourseController implements AcademyControllerTrait {

    @Override
    def targetDomainClass() {
        return AcademyCourse
    }


    def index() {
        def courseInstanceList = targetDomainClass().findAll()

        render model: [courseInstanceClass: targetDomainClass(),
                       courseInstanceList : courseInstanceList], view: '/course/index'
    }

    def show(AcademyCourse courseInstance) {
        courseInstance.clearErrors()
        render model: [courseInstance: courseInstance], view: '/course/show'
    }

    def create() {
        render model: [courseInstance: targetDomainClass()
                .newInstance(params)], view: '/course/create'
    }

    @Transactional
    def save(AcademyCourse course) {
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

        course = persistNew(AcademyCourse) {
            tittle = course.tittle
            description = course.description
            createdOn = new Date()
            courseType = course.courseType
            active = course.active
        }

        showMessage(course.tittle, "default.created.message")
        redirect course
    }


    def edit(AcademyCourse course) {
        render model: [courseInstance: course], view: '/course/edit'
    }

    @Transactional
    def update(AcademyCourse course) {
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
