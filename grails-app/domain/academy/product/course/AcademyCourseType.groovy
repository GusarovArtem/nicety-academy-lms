package academy.product.course

class AcademyCourseType {

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


