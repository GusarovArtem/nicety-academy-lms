package academy.user.fields

import academy.user.SocialMedia
import academy.user.User

class UserSocialMedia implements Serializable {

    User user

    SocialMedia socialMedia

    static constraints = {
        user nullable: false
        socialMedia nullable: false
    }

    static mapping = {
        id composite: ['user', 'socialMedia']
    }

}
