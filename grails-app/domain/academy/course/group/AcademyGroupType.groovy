package academy.course.group

class AcademyGroupType {

    enum Code {
        ONLINE, OFFLINE
    }

    Code code

    String label

    static constraints = {
        code nullable: false
        label nullable: false
    }
}
