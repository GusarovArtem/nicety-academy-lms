package academy.course


import academy.trait.AcademyControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class AcademyCourseTypeController implements AcademyControllerTrait {

    @Override
    def targetDomainClass() {
        return AcademyCourseType
    }

    def index() {
        def courseInstanceList = targetDomainClass().findAll()

        render model: [courseInstanceClass: targetDomainClass(),
                       courseInstanceList : courseInstanceList], view: '/course/index'
    }

    def show(AcademyCourse courseInstance) {
        courseInstance.clearErrors()
        render model: [courseInstance: courseInstance], view: '/courseType/show'
    }

    def create() {
        render model: [courseInstance: targetDomainClass()
                .newInstance(params)], view: '/courseType/create'
    }

    @Transactional
    def save(AcademyCourse course) {
        if (!course) {
            notFound()
            return
        }

        course.createdOn = new Date()
        course.clearErrors()
        course.validate()

        if (course.hasErrors()) {
            render model: [courseInstance: course], view: '/courseType/create'
            return
        }

        course.save flush: true

        showMessage(course.tittle, "default.created.message")
        redirect course
    }


}
