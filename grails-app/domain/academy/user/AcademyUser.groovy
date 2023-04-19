package academy.user


import academy.user.role.AcademyUserRole
import org.apache.commons.lang3.StringUtils
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

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

    Collection<GrantedAuthority> authorities() {
        AcademyUserRole.findAllByUser(this).collect {
            new SimpleGrantedAuthority(it.role.authority)
        }
    }


    def beforeInsert() {
        capitalizeName()
    }

    protected void capitalizeName() {
        name = StringUtils.capitalize(name)
        surname = StringUtils.capitalize(surname)
    }

}
