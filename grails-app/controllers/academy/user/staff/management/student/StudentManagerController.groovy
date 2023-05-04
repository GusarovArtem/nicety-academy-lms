package academy.user.staff.management.student

import academy.user.UserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class StudentManagerController implements UserControllerTrait {

    def userDomainClass() {
        return StudentManager
    }
    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_HR'])
    def show(StudentManager userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(StudentManager userInstance) {
        _save(userInstance)
    }

    def edit(StudentManager userInstance) {
        _edit(userInstance)
    }

    def selfEdit(StudentManager userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(StudentManager userInstance) {
        _update(userInstance)
    }

    @Transactional
    def selfUpdate(StudentManager userInstance) {
        _selfUpdate(userInstance)
    }

}

