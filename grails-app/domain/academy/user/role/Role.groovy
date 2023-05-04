package academy.user.role

class Role {

    String authority

    static mapping = {
        cache usage: 'read-only'
    }

    static constraints = {
        authority blank: false, unique: true
    }
}
