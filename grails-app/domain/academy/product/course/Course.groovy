package academy.product.course

import academy.product.course.group.Group
import academy.product.price.ProductPrice

class Course {

    String tittle

    String description

    Date createdOn

    ProductPrice coursePrice

    CourseType courseType

    boolean active

    static hasMany = [groups: Group]

    static constraints = {
        tittle       blank: false
        description  blank: false
        createdOn    nullable: true
        coursePrice  nullable: false
        courseType   nullable: false
    }


}

