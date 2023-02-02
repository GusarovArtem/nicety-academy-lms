package academy.user

import academy.user.security.AcademyRole
import academy.user.security.AcademyUserRole
import academy.user.security.AcademyUserType

class AcademyUser {

    transient springSecurityService

    String name
    String surname

    String email

    String password
    String passwordConfirm

    Date createdOn

    Date dateOfBirth

    String phoneNumber

    String location

    AcademyUserType userType

    AcademyEnglishLevel englishLevel

    boolean enabled
    boolean accountExpired
    boolean passwordExpired
    boolean accountLocked

    static transients = ['springSecurityService', 'passwordConfirm']

    static constraints = {
        email(blank: false, email: true, validator: { value, user ->
            String login = value.trim()

            def notUnique
            if (AcademyUser.findAllByEmail(login).find { it.id != user.id }) {
                notUnique = ['AcademyUser.email.unique']
            }
            if (notUnique) {
                return notUnique
            }

            true
        })

        password(nullable: false, blank: false, password: true)
        passwordConfirm(nullable: false, blank: false, bindable: true, password: true, validator: { val, obj ->
            obj.password == val ? true :
                    ['invalid.matchingpasswords']
        })

        name         blank: false
        surname      blank: false
        createdOn    nullable: false
        userType     nullable: false

        phoneNumber  nullable: true
        dateOfBirth  nullable: true
        location     nullable: true
        englishLevel nullable: true
    }

    Set<AcademyRole> authorities() {
        AcademyUserRole.findAllByUser(this).collect { it.role } as Set
    }

    def afterLoad() {
        passwordConfirm = password
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (password != null && passwordConfirm != null && isDirty('password') && validate()) {
            encodePassword()
        }
    }

//  TODO inject springSecurityService dependency
    protected void encodePassword() {
//        password = springSecurityService.encodePassword(password)
        passwordConfirm = password
    }

}
