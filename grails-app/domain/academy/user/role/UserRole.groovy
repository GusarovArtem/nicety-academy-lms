package academy.user.role


import academy.user.AcademyUser

class UserRole implements Serializable {

    AcademyUser user
    Role role

    static mapping = {
        id composite: ['user', 'role']
    }

    static constraints = {
        user nullable: true, unique: true
        role nullable: true
    }

    UserRole(AcademyUser user, Role role) {
        this.user = user
        this.role = role
    }

    static UserRole create(AcademyUser user, boolean flush = false) {
        def role = Role.findByAuthority(user.userType.role)

        new UserRole(user: user, role: role).save(flush: flush, insert: true)
    }
}

