package academy.user.student

import academy.user.AcademyUserControllerTrait
import academy.user.staff.service.AcademyTeacher
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class AcademyStudentController implements AcademyUserControllerTrait {

    def userDomainClass() {
        return AcademyTeacher
    }

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        _index(max)
    }

    def show(AcademyTeacher userInstance) {
        _show(userInstance)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        _create()
    }

    @Transactional
    @Secured(['ROLE_ADMIN', 'ROLE_STUDENT'])
    def save(AcademyTeacher userInstance) {
        _save(userInstance)
    }

    @Secured(['ROLE_ADMIN'])
    def edit(AcademyTeacher userInstance) {
        _edit(userInstance)
    }

    @Secured(['ROLE_STUDENT'])
    def selfEdit(AcademyTeacher userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def update(AcademyTeacher userInstance) {
        _update(userInstance)
    }

    @Transactional
    @Secured(['ROLE_STUDENT'])
    def selfUpdate(AcademyTeacher userInstance) {
        _selfUpdate(userInstance)
    }

}

