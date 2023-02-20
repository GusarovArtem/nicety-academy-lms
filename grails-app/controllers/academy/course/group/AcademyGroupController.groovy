package academy.course.group


import academy.trait.AcademyControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class AcademyGroupController implements AcademyControllerTrait {

    @Override
    def targetDomainClass() {
        return AcademyGroup
    }


    def index() {
        def groupInstanceList = targetDomainClass().findAll()

        render model: [groupInstanceClass: targetDomainClass(),
                       groupInstanceList : groupInstanceList], view: '/course/group/index'
    }

    def show(AcademyGroup groupInstance) {
        groupInstance.clearErrors()
        render model: [groupInstance: groupInstance], view: '/course/group/show'
    }

    def create() {
        render model: [groupInstance: targetDomainClass()
                .newInstance(params)], view: '/course/group/create'
    }

    @Transactional
    def save(AcademyGroup group) {
        if (!group) {
            notFound()
            return
        }

        group.createdOn = new Date()
        group.clearErrors()
        group.validate()

        if (group.hasErrors()) {
            render model: [groupInstance: group], view: '/course/group/create'
            return
        }

        group.save flush: true

        showMessage(group.name, "default.created.message")
        redirect group
    }


    def edit(AcademyGroup group) {
        render model: [groupInstance: group], view: '/course/group/edit'
    }

    def update(AcademyGroup group) {
        if (group == null) {
            notFound()
            return
        }

        group.validate()

        if (group.hasErrors()) {
            render model: [groupInstance: group], view: '/course/group/edit'
            return
        }

        group.save flush: true

        showMessage(group.name, 'academyGroup.updated')
        redirect group

    }

}
