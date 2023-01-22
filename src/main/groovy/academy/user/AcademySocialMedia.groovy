package academy.user

enum AcademySocialMedia {
    LINKEDIN("Linkedin", "https://www.linkedin.com/example"),
    TELEGRAM("Telegram", "username"),
    FACEBOOK("Facebook", "https://www.facebook.com/example"),
    INSTAGRAM("Instagram", "https://www.instagram.com/example");

    String label

    String placeholder

    AcademySocialMedia(String label, String placeholder) {
        this.label = label
        this.placeholder = placeholder
    }
}