package academy.user


import academy.user.role.AcademyRole
import academy.user.role.AcademyUserRole
import org.apache.commons.lang3.StringUtils

class AcademyUser {

    def springSecurityService

    String name
    String surname

    String email

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

    static mapping = {
        autowire true
    }

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

    String fullname() {
        name + " " + surname
    }

    Set<AcademyRole> authorities() {
        AcademyUserRole.findAllByUser(this).collect { it.role } as Set
    }


    def beforeInsert() {
        capitalizeName()
    }

    protected void capitalizeName() {
        name = StringUtils.capitalize(name)
        surname = StringUtils.capitalize(surname)
    }

}
