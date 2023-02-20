package academy.user.staff.service

import academy.user.AcademyUserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class AcademyTeacherController implements AcademyUserControllerTrait {

    def userDomainClass() {
        return AcademyTeacher
    }
    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_STUDENT'])
    def show(AcademyTeacher userInstance) {
        _show(userInstance)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        _create()
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def save(AcademyTeacher userInstance) {
        _save(userInstance)
    }

    @Secured(['ROLE_ADMIN'])
    def edit(AcademyTeacher userInstance) {
        _edit(userInstance)
    }

    @Secured(['ROLE_TEACHER'])
    def selfEdit(AcademyTeacher userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def update(AcademyTeacher userInstance) {
        _update(userInstance)
    }

    @Transactional
    @Secured(['ROLE_TEACHER'])
    def selfUpdate(AcademyTeacher userInstance) {
        _selfUpdate(userInstance)
    }

}

