package academy.course

class AcademyCourseType {

    enum Code {
        PROGRAMMING,
        DESIGN,
        MANAGEMENT,
        BUSINESS,
        ENGLISH;
    }

    Code code

    String label

    static constraints = {
        code blank: false
        label blank: false
    }

}


