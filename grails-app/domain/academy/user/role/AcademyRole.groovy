package academy.user.role

class AcademyRole {

    String authority

    static mapping = {
        cache usage: 'read-only'
    }

    static constraints = {
        authority blank: false, unique: true
    }
}
