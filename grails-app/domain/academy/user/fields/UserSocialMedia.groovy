package academy.user.fields

import academy.user.SocialMedia
import academy.user.AcademyUser

class UserSocialMedia implements Serializable {

    AcademyUser user

    SocialMedia socialMedia

    static constraints = {
        user nullable: false
        socialMedia nullable: false
    }

    static mapping = {
        id composite: ['user', 'socialMedia']
    }

}
