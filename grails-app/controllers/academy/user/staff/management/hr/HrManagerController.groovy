package academy.user.staff.management.hr

import academy.user.UserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class HrManagerController implements UserControllerTrait {

    def userDomainClass() {
        return HrManager
    }

    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_TEACHER', 'ROLE_STUDENT', 'ROLE_HR'])
    def show(HrManager userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(HrManager userInstance) {
        _save(userInstance)
    }

    def edit(HrManager userInstance) {
        _edit(userInstance)
    }

    @Secured(['ROLE_TEACHER'])
    def selfEdit(HrManager userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def update(HrManager userInstance) {
        _update(userInstance)
    }

    @Transactional
    @Secured(['ROLE_TEACHER'])
    def selfUpdate(HrManager userInstance) {
        _selfUpdate(userInstance)
    }

}

