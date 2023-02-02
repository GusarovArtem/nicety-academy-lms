package academy.user.security

enum AcademyUserType {

    SYSTEM_USER(null, null),
    ADMIN("admin", "ROLE_ACADEMY_ADMIN");

    String role

    String controller

    AcademyUserType(String controller, String role) {
        this.controller = controller
        this.role = role
    }
}