package academy.security

import academy.user.AcademyUser

class AcademySecurityService {

    def springSecurityService


    AcademyUser currentUser() {
        (AcademyUser) springSecurityService.currentUser
    }

}
