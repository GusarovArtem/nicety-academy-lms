package academy.user.security

import academy.user.AcademyUser

class AcademyUserRole implements Serializable {

    AcademyUser user
    AcademyRole role

    static mapping = {
        id composite: ['user', 'role']
    }

    static constraints = {
        user nullable: true, unique: true
        role nullable: true
    }

    AcademyUserRole(AcademyUser user, AcademyRole role) {
        this.user = user
        this.role = role
    }

    static AcademyUserRole create(AcademyUser user, AcademyRole role, boolean flush = false) {
        new AcademyUserRole(user: user, role: role).save(flush: flush, insert: true)
    }
}

