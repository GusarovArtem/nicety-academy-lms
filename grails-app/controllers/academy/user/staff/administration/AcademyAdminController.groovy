package academy.user.staff.administration

import academy.user.AcademyUserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class AcademyAdminController implements AcademyUserControllerTrait {

    def userDomainClass() {
        return AcademyAdmin
    }

    def index(Integer max) {
        _index(max)
    }

    def show(AcademyAdmin userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(AcademyAdmin userInstance) {
        _save(userInstance)
    }

    def edit(AcademyAdmin userInstance) {
        _edit(userInstance)
    }

    def selfEdit(AcademyAdmin userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(AcademyAdmin userInstance) {
        _update(userInstance)
    }

    @Transactional
    def selfUpdate(AcademyAdmin userInstance) {
        _selfUpdate(userInstance)
    }
}

