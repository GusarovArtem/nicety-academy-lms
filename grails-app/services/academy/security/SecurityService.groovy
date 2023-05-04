package academy.security

import academy.user.User

class SecurityService {

    def springSecurityService


    User currentUser() {
        (User) springSecurityService.currentUser
    }

}
