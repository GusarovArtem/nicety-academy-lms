package academy.user.staff.administration

import academy.user.UserControllerTrait
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class AdminController implements UserControllerTrait {

    def userDomainClass() {
        return Admin
    }

    def index(Integer max) {
        _index(max)
    }

    def show(Admin userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(Admin userInstance) {
        _save(userInstance)
    }

    def edit(Admin userInstance) {
        _edit(userInstance)
    }

    def selfEdit(Admin userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(Admin userInstance) {
        _update(userInstance)
    }

    @Transactional
    def selfUpdate(Admin userInstance) {
        _selfUpdate(userInstance)
    }
}

