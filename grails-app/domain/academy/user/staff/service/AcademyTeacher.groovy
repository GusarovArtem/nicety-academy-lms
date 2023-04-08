package academy.user.staff.service

import academy.user.AcademyUser
import academy.user.AcademyUserType

class AcademyTeacher extends AcademyUser {

    {
        this.userType = AcademyUserType.TEACHER
    }

}
