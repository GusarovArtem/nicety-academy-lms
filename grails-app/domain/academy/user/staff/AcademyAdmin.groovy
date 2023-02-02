package academy.user.staff

import academy.user.AcademyUser
import academy.user.security.AcademyUserType

class AcademyAdmin extends AcademyUser {

    {
        this.userType = AcademyUserType.ADMIN
    }

}
