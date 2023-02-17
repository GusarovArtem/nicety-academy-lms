package academy.user

import academy.trait.AcademyControllerTrait

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

}
