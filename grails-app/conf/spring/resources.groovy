import academy.jwt.JwtAuthProviderService

// Place your Spring DSL code here
beans = {
    jwtAuthProviderService(JwtAuthProviderService) {
        jwtValidatorService = ref('jwtValidatorService')
    }
}
