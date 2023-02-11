package academy.user.security

enum AcademyUserType {

    SYSTEM_USER(null, "ROLE_SYSTEM_USER"),
    ADMIN("admin", "ROLE_ADMIN");

    String role

    String controller

    AcademyUserType(String controller, String role) {
        this.controller = controller
        this.role = role
    }
}