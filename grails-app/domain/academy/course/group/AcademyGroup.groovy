package academy.course.group

import academy.user.student.AcademyStudent

class AcademyGroup {

    String name

    Date createdOn

    byte maxStudentAmount

    AcademyGroupType groupType

    static hasMany = [students: AcademyStudent]

    static constraints = {
        name             blank: false
        createdOn        nullable: false
        maxStudentAmount nullable: false
        groupType        nullable: false
    }


}

