package academy.user.staff.management.student

import academy.user.AcademyUserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class AcademyStudentManagerController implements AcademyUserControllerTrait {

    def userDomainClass() {
        return AcademyStudentManager
    }
    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_HR'])
    def show(AcademyStudentManager userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(AcademyStudentManager userInstance) {
        _save(userInstance)
    }

    def edit(AcademyStudentManager userInstance) {
        _edit(userInstance)
    }

    def selfEdit(AcademyStudentManager userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(AcademyStudentManager userInstance) {
        _update(userInstance)
    }

    @Transactional
    def selfUpdate(AcademyStudentManager userInstance) {
        _selfUpdate(userInstance)
    }

}

