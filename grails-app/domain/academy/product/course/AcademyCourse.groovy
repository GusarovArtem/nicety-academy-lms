package academy.product.course

import academy.product.course.group.AcademyGroup
import academy.product.price.AcademyProductPrice

class AcademyCourse {

    String tittle

    String description

    Date createdOn

    AcademyProductPrice coursePrice

    AcademyCourseType courseType

    boolean active

    static hasMany = [groups: AcademyGroup]

    static constraints = {
        tittle       blank: false
        description  blank: false
        createdOn    nullable: true
        coursePrice  nullable: false
        courseType   nullable: false
    }


}

