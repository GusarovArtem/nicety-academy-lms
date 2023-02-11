package academy

import academy.user.security.AcademyRole
import academy.user.security.AcademyUserRole
import academy.user.security.AcademyUserType
import academy.user.staff.AcademyAdmin

class BootStrap {

    def grailsApplication

    def domainService

    def init = { servletContext ->

        log.info 'BOOTSTRAPPING start'

        createAcademyRolesIfNotExist()
        createSuperAdminIfNotExists()

        log.info 'BOOTSTRAPPING end'

    }

    def destroy = {
    }

    private void createAcademyRolesIfNotExist() {
        createAcademyRoleIfNotExists(AcademyUserType.SYSTEM_USER)
        createAcademyRoleIfNotExists(AcademyUserType.ADMIN)
    }

    private void createAcademyRoleIfNotExists(AcademyUserType userType) {
        domainService.createIfNotExists(
                { AcademyRole.findByAuthority(userType.role) },
                { new AcademyRole(authority: userType.role) }
        )
    }

    private void createSuperAdminIfNotExists() {
        def SUPER_ADMIN = grailsApplication.config.academy.user.super_admin
        AcademyAdmin admin

        domainService.createAllIfNotExist(
                { AcademyAdmin.findByEmail(SUPER_ADMIN.email) },
                [
                    {
                        admin = new AcademyAdmin(
                            createdOn: new Date(),
                            name     : SUPER_ADMIN.name,
                            surname  : SUPER_ADMIN.surname,
                            email    : SUPER_ADMIN.email,
                            password : SUPER_ADMIN.password,
                            passwordConfirm: SUPER_ADMIN.password
                         )
                    },
                    {
                        new AcademyUserRole(admin, AcademyRole.findByAuthority(AcademyUserType.ADMIN.role))
                    }
                ]
        )
    }

}
