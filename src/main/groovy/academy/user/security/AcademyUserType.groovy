package academy.user.security

enum AcademyUserType {

    SYSTEM_USER(null, "ROLE_SYSTEM_USER"),
    STUDENT("student", "ROLE_STUDENT"),
//  Service
    TEACHER("teacher", "ROLE_TEACHER"),
//  Administration
    ADMIN("admin", "ROLE_ADMIN");

    String role

    String controller

    AcademyUserType(String controller, String role) {
        this.controller = controller
        this.role = role
    }
}