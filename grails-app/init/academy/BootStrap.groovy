package academy

import academy.user.role.Role
import academy.user.role.UserRole
import academy.user.UserType
import academy.user.staff.administration.Admin

class BootStrap {

    def grailsApplication

    def domainService

    def reactorsRegistrarService

    def init = { servletContext ->

        log.info 'BOOTSTRAPPING start'

        reactorsRegistrarService.reconfigureAll()

        createAcademyRolesIfNotExist()
        createSuperAdminIfNotExists()

        log.info 'BOOTSTRAPPING end'

    }

    def destroy = {
    }

    private void createAcademyRolesIfNotExist() {
        createAcademyRoleIfNotExists(UserType.SYSTEM_USER)
        createAcademyRoleIfNotExists(UserType.STUDENT)
        createAcademyRoleIfNotExists(UserType.TEACHER)
        createAcademyRoleIfNotExists(UserType.ADMIN)
    }

    private void createAcademyRoleIfNotExists(UserType userType) {
        domainService.createIfNotExists(
                { Role.findByAuthority(userType.role) },
                { new Role(authority: userType.role) }
        )
    }

    private void createSuperAdminIfNotExists() {
        def SUPER_ADMIN = grailsApplication.config.academy.user.super_admin
        Admin admin

        domainService.createAllIfNotExist(
                { Admin.findByEmail(SUPER_ADMIN.email) },
                [
                    {
                        admin = new Admin(
                            enabled: true,
                            createdOn: new Date(),
                            name     : SUPER_ADMIN.name,
                            surname  : SUPER_ADMIN.surname,
                            email    : SUPER_ADMIN.email,
                         )
                    },
                    {
                        new UserRole(admin, Role.findByAuthority(UserType.ADMIN.role))
                    }
                ]
        )
    }

}
