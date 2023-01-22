package academy.user

enum AcademyEnglishLevel {

    ELEMENTARY("Elementary"),
    PRE_INTERMEDIATE("Pre-Intermediate"),
    INTERMEDIATE("Intermediate"),
    UPPER_INTERMEDIATE("Upper-Intermediate"),
    ADVANCED("Advanced");

    String label

    AcademyEnglishLevel(String label) {
        this.label = label
    }

}