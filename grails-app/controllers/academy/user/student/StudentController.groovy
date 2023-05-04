package academy.user.student

import academy.user.UserControllerTrait
import academy.user.staff.service.Teacher
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class StudentController implements UserControllerTrait {

    def userDomainClass() {
        return Teacher
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_STUDENT_MANAGER'])
    def index(Integer max) {
        _index(max)
    }

    def show(Teacher userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(Teacher userInstance) {
        _save(userInstance)
    }

    def edit(Teacher userInstance) {
        _edit(userInstance)
    }

    def selfEdit(Teacher userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(Teacher userInstance) {
        _update(userInstance)
    }

    @Transactional
    def selfUpdate(Teacher userInstance) {
        _selfUpdate(userInstance)
    }

}

