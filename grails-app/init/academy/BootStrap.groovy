package academy

import academy.user.staff.AcademyAdmin

class BootStrap {

    def grailsApplication

    def domainService

    def init = { servletContext ->

        log.info 'BOOTSTRAPPING start'

        createSuperAdminIfNotExist()

        log.info 'BOOTSTRAPPING end'

    }

    def destroy = {
    }

    void createSuperAdminIfNotExist() {
        def superAdminProperties = grailsApplication.config.academy.user.super_admin

        domainService.createIfNotExists({ AcademyAdmin.findByEmail(superAdminProperties.email) },
                {
                    new AcademyAdmin(
                            createdOn: new Date(),
                            name     : superAdminProperties.name,
                            surname  : superAdminProperties.surname,
                            email    : superAdminProperties.email,
                            password : superAdminProperties.password,
                            passwordConfirm: superAdminProperties.password
                    )
                })
    }

}
