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
}

