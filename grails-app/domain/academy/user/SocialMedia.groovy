package academy.user

enum SocialMedia {
    LINKEDIN("Linkedin", "https://www.linkedin.com/example"),
    TELEGRAM("Telegram", "username"),
    FACEBOOK("Facebook", "https://www.facebook.com/example"),
    INSTAGRAM("Instagram", "https://www.instagram.com/example");

    String label

    String placeholder

    SocialMedia(String label, String placeholder) {
        this.label = label
        this.placeholder = placeholder
    }
}