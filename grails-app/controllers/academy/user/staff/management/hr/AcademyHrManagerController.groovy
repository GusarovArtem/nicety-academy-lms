package academy.user.staff.management.hr

import academy.user.AcademyUserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class AcademyHrManagerController implements AcademyUserControllerTrait {

    def userDomainClass() {
        return AcademyHrManager
    }

    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_TEACHER', 'ROLE_STUDENT', 'ROLE_HR'])
    def show(AcademyHrManager userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(AcademyHrManager userInstance) {
        _save(userInstance)
    }

    def edit(AcademyHrManager userInstance) {
        _edit(userInstance)
    }

    @Secured(['ROLE_TEACHER'])
    def selfEdit(AcademyHrManager userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def update(AcademyHrManager userInstance) {
        _update(userInstance)
    }

    @Transactional
    @Secured(['ROLE_TEACHER'])
    def selfUpdate(AcademyHrManager userInstance) {
        _selfUpdate(userInstance)
    }

}

