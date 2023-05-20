package academy.user.staff.service

import academy.user.AcademyUser
import academy.user.UserType

class Teacher extends AcademyUser {

    {
        this.userType = UserType.TEACHER
    }

}
