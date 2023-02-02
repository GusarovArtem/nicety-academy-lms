academy {
    user {
        super_admin {
            name = "Artem"
            surname = "Gusarov"
            email = "nicety.academy@gmail.com"
            password = "cbbcc56f20efc1a8713ad014a0"
        }
    }
}

// QUARTZ
quartz {
    autoStartup = false

    globalJobListenerNames = []
    globalTriggerListenerNames = []
    schedulerListenerNames = []
}

// CACHE
grails {
    cache {
        enabled = true

        ehcache {
            ehcacheXmlLocation = 'classpath:ehcache-cache-plugin.xml'
            lockTimeout = 200 // In milliseconds
        }
    }
}

//SPRING SECURITY
grails.plugin.springsecurity.userLookup.usernamePropertyName = 'email'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'academy.user.AcademyUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'academy.user.security.AcademyUserRole'
grails.plugin.springsecurity.authority.className = 'academy.user.security.AcademyRole'

grails.plugin.springsecurity.useSwitchUserFilter = true

grails.plugin.springsecurity.rememberMe.cookieName = "academyRememberMeCookieName"
grails.plugin.springsecurity.rememberMe.key = "academyRememberMeKEY"
grails.plugin.springsecurity.rememberMe.tokenValiditySeconds = 1209600

grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.basic.realmName = "Academy basic auth realm"
grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/api/errorraport',    filters: 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter'],
        [pattern: '/api/errorraport/**', filters: 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter'],
        [pattern: '/api/**',             filters: 'JOINED_FILTERS,-exceptionTranslationFilter'],
        [pattern: '/**',                 filters: 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter']
]

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.alwaysUseDefaultTargetUrl = true

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/login/**', access: ['permitAll']],
        [pattern: '/logout/**', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/static/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],

        [pattern: '/selfInstallationConfirmation', access: ['permitAll']],
        [pattern: '/selfInstallationConfirmation/**', access: ['permitAll']],
        [pattern: '/language', access: ['permitAll']],
        [pattern: '/language/**', access: ['permitAll']],
        [pattern: '/simpleCaptcha/captcha', access: ['permitAll']],

        [pattern: '/api/errorraport', access: ['permitAll']],
        [pattern: '/api/errorraport/**', access: ['permitAll']],

        [pattern: '/api/ticket', access: ['permitAll']],
        [pattern: '/api/ticket/**', access: ['permitAll']],

        [pattern: '/grails/**', access: ['ROLE_SUPER_ADMIN']],
        [pattern: '/console/**', access: ['ROLE_SUPER_ADMIN']],
        [pattern: '/static/console/**', access: ['ROLE_SUPER_ADMIN']],

        [pattern: '/dbconsole/**', access: ['ROLE_SUPER_ADMIN']],
        [pattern: '/platform/**', access: ['ROLE_SUPER_ADMIN']],
        [pattern: '/buildInfo/**', access: ['ROLE_SUPER_ADMIN']],
        [pattern: '/monitoring/**', access: ['ROLE_SUPER_ADMIN']],
]

grails.plugin.console.csrfProtection.enabled = false
