package academy.course

import academy.course.group.AcademyGroup

class AcademyCourse {

    String tittle

    String description

    Date createdOn

    AcademyCourseType courseType

    boolean active

    static hasMany = [groups: AcademyGroup]

    static constraints = {
        tittle       blank: false
        description  blank: false
        createdOn    nullable: true
        courseType   nullable: false
    }


}

