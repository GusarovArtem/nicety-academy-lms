package academy.product.course

class CourseType {

    enum Code {
        PROGRAMMING,
        DESIGN,
        MANAGEMENT,
        BUSINESS,
        ENGLISH;
    }

    Code code

    String tittle

    static constraints = {
        code blank: false
        tittle blank: false
    }

}


