package academy.user

import academy.user.fields.AcademyUserSocialMedia

class AcademyUser {

    String name
    String surname

    String email

    Date createdOn

    Date dateOfBirth

    String phoneNumber

    String location

    AcademyEnglishLevel englishLevel

    static constraints = {
        name        nullable: false
        email       nullable: false
        createdOn   nullable: false
        phoneNumber nullable: false

        surname      nullable: true
        dateOfBirth  nullable: true
        location     nullable: true
        englishLevel nullable: true
    }
}
