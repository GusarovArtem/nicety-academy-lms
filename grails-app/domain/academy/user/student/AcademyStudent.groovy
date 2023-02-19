package academy.user.student

import academy.user.AcademyUser
import academy.user.security.AcademyUserType

class AcademyStudent extends AcademyUser {

    {
        this.userType = AcademyUserType.STUDENT
    }

}
