package academy.security


import academy.user.AcademyUser

class SecurityService {

    def springSecurityService


    AcademyUser currentUser() {
        (AcademyUser) springSecurityService.currentUser
    }

}
