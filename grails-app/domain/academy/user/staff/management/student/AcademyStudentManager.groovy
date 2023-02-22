package academy.user.staff.management.student

import academy.user.security.AcademyUserType
import academy.user.staff.management.AcademyManager

class AcademyStudentManager extends AcademyManager {

    {
        this.userType = AcademyUserType.STUDENT_MANAGER
    }

}
