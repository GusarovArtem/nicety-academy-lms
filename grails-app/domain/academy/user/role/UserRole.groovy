package academy.user.role

import academy.user.User

class UserRole implements Serializable {

    User user
    Role role

    static mapping = {
        id composite: ['user', 'role']
    }

    static constraints = {
        user nullable: true, unique: true
        role nullable: true
    }

    UserRole(User user, Role role) {
        this.user = user
        this.role = role
    }

    static UserRole create(User user, boolean flush = false) {
        def role = Role.findByAuthority(user.userType.role)

        new UserRole(user: user, role: role).save(flush: flush, insert: true)
    }
}

