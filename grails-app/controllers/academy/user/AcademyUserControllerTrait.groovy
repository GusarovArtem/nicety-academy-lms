package academy.user

import academy.trait.AcademyControllerTrait
import academy.user.security.AcademyUserRole

trait AcademyUserControllerTrait implements AcademyControllerTrait {

    @Override
    def targetDomainClass() {
        userDomainClass()
    }

    @Override
    void showMessage(String target, String code, String defaultCode) {
        super.showMessage(target, code, 'User')
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

        academyUser.clearErrors()
        academyUser.validate()

        if (academyUser.hasErrors()) {
            render model: [userInstance: academyUser], view: '/user/create'
            return
        }

        academyUser.save flush: true
        AcademyUserRole.create(academyUser, academyUser.userType.role, true)

        showMessage(academyUser.fullname(), "default.created.message")
        redirect academyUser
    }

}
