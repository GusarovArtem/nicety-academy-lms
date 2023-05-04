package academy.product.course.group

import academy.user.student.Student

class Group {

    String name

    Date createdOn

    byte maxStudentAmount

    GroupType groupType

    static hasMany = [students: Student]

    static constraints = {
        name             blank: false
        createdOn        nullable: false
        maxStudentAmount nullable: false
        groupType        nullable: false
    }


}

