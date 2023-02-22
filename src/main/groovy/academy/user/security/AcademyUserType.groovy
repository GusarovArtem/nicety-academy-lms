package academy.user.security

enum AcademyUserType {

    SYSTEM_USER(null, "ROLE_SYSTEM_USER"),

//  Administration
    ADMIN("admin", "ROLE_ADMIN"),
//  Management
    MANAGER("manager", "ROLE_MANAGER"),
    HR_MANAGER("manager", "ROLE_HR_MANAGER"),
//  Service
    TEACHER("teacher", "ROLE_TEACHER"),
//  STUDENT
    STUDENT("student", "ROLE_STUDENT");

    String role

    String controller

    AcademyUserType(String controller, String role) {
        this.controller = controller
        this.role = role
    }
}