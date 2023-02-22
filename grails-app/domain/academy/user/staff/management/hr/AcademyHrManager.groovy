package academy.user.staff.management.hr


import academy.user.security.AcademyUserType
import academy.user.staff.management.AcademyManager

class AcademyHrManager extends AcademyManager {

    {
        this.userType = AcademyUserType.HR_MANAGER
    }
}
