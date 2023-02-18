package academy.user

import academy.user.field.AcademyEnglishLevel
import academy.user.security.AcademyRole
import academy.user.security.AcademyUserRole
import academy.user.security.AcademyUserType
import org.apache.commons.lang3.StringUtils

class AcademyUser {

    def springSecurityService

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

    static mapping = {
        autowire true
    }

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

    String fullname() {
        name + " " + surname
    }

    Set<AcademyRole> authorities() {
        AcademyUserRole.findAllByUser(this).collect { it.role } as Set
    }

    def afterLoad() {
        passwordConfirm = password
    }

    def beforeInsert() {
        encodePassword()
        capitalizeName()
    }

    def beforeUpdate() {
        if (password != null && isDirty('password') && validate()) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
        passwordConfirm = password
    }

    protected void capitalizeName() {
        name = StringUtils.capitalize(name)
        surname = StringUtils.capitalize(surname)
    }

}
