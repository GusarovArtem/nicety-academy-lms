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
        def courseTypeInstanceList = targetDomainClass().findAll()

        render model: [courseTypeInstanceClass: targetDomainClass(),
                       courseTypeInstanceList : courseTypeInstanceList], view: '/course/type/index'
    }

    def show(AcademyCourseType courseTypeInstance) {
        courseTypeInstance.clearErrors()
        render model: [courseTypeInstance: courseTypeInstance], view: '/course/type/show'
    }

    def create() {
        render model: [courseTypeInstance: targetDomainClass()
                .newInstance(params)], view: '/course/type/create'
    }

    @Transactional
    def save(AcademyCourseType course) {
        if (!course) {
            notFound()
            return
        }

        course.clearErrors()
        course.validate()

        if (course.hasErrors()) {
            render model: [courseTypeInstance: course], view: '/course/type/create'
            return
        }

        course.save flush: true

        showMessage(course.tittle, "default.created.message")
        redirect course
    }


}
