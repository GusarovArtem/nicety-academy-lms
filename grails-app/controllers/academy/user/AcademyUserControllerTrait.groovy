package academy.user

import academy.trait.AcademyControllerTrait
import academy.user.security.AcademyUserRole

trait AcademyUserControllerTrait implements AcademyControllerTrait {

    @Override
    def targetDomainClass() {
        userDomainClass()
    }

    @Override
    void showMessage(academyUser, String code, String defaultCode = 'User') {
        super.showMessage(academyUser.fullname(), code, defaultCode)
    }

    def _index(Integer max) {
        def userInstanceList = targetDomainClass().findAll()

        render model: [userInstanceClass: targetDomainClass(),
                       userInstanceList : userInstanceList], view: '/user/index'
    }

    def _show(AcademyUser userInstance) {
        userInstance.clearErrors()
        render model: [userInstance: userInstance], view: '/user/show'
    }

    def _create() {
        render model: [userInstance: targetDomainClass()
                .newInstance(params)], view: '/user/create'
    }

    def _save(AcademyUser academyUser) {
        if (!academyUser) {
            notFound()
            return
        }

        academyUser.createdOn = new Date()
        academyUser.clearErrors()
        academyUser.validate()

        if (academyUser.hasErrors()) {
            render model: [userInstance: academyUser], view: '/user/create'
            return
        }

        academyUser.save flush: true
        AcademyUserRole.create(academyUser, true)

        showMessage(academyUser, "default.created.message")
        redirect academyUser
    }


    def _edit(AcademyUser academyUser) {
        render model: [userInstance: academyUser], view: '/user/edit'
    }

    def _selfEdit(AcademyUser userInstance) {
        render model: [userInstance: userInstance], view: '/user/self_edit'
    }

    def _update(AcademyUser academyUser) {
        update(userInstance, "edit")
    }

    def _selfUpdate(AcademyUser userInstance) {
        update(userInstance, "self_edit")
    }

    private update(AcademyUser academyUser, view) {
        if (academyUser == null) {
            notFound()
            return
        }

        academyUser.validate()

        if (academyUser.hasErrors()) {
            render model: [userInstance: academyUser], view: view
            return
        }

        academyUser.save flush: true

        showMessage(academyUser, 'account.updated')
        redirect academyUser
    }

}
