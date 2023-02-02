
// Place your Spring DSL code here
beans = {
    userDetailsService(academy.user.security.AcademyUserDetailsService){
        grailsApplication = ref('grailsApplication')
    }

}
