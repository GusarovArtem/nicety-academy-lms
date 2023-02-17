package academy.user

import academy.user.staff.AcademyAdmin
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

}

