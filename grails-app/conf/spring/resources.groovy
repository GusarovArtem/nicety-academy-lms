import academy.user.security.AcademyUserDetailsService

// Place your Spring DSL code here
beans = {
    userDetailsService(AcademyUserDetailsService){ grailsApplication = ref('grailsApplication') }

}
