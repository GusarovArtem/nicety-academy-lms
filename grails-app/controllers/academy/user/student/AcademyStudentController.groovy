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

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_STUDENT_MANAGER'])
    def index(Integer max) {
        _index(max)
    }

    def show(AcademyTeacher userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(AcademyTeacher userInstance) {
        _save(userInstance)
    }

    def edit(AcademyTeacher userInstance) {
        _edit(userInstance)
    }

    def selfEdit(AcademyTeacher userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(AcademyTeacher userInstance) {
        _update(userInstance)
    }

    @Transactional
    def selfUpdate(AcademyTeacher userInstance) {
        _selfUpdate(userInstance)
    }

}

