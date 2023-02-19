package academy.user.staff.service

import academy.user.AcademyUser
import academy.user.security.AcademyUserType

class AcademyTeacher extends AcademyUser {

    {
        this.userType = AcademyUserType.TEACHER
    }

}
