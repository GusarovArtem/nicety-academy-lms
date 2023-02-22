package academy.user.staff.management

import academy.user.AcademyUser
import academy.user.security.AcademyUserType

class AcademyManager extends AcademyUser {

    {
        this.userType = AcademyUserType.MANAGER
    }

}
