package academy.user.fields

import academy.user.AcademySocialMedia
import academy.user.AcademyUser

class AcademyUserSocialMedia {

    AcademyUser user

    AcademySocialMedia socialMedia

    static constraints = {
        user nullable: false
        socialMedia nullable: false
    }

    static mapping = {
        id composite: ['user', 'socialMedia']
    }

}
