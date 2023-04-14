import academy.jwt.JwtAuthProviderService
import org.springframework.web.client.RestTemplate

// Place your Spring DSL code here
beans = {
    restTemplate(RestTemplate)

    jwtAuthProviderService(JwtAuthProviderService) {
        jwtValidatorService = ref('jwtValidatorService')
        restTemplate = ref('restTemplate')
    }
}