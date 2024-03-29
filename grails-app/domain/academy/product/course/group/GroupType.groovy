package academy.product.course.group

class GroupType {

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
