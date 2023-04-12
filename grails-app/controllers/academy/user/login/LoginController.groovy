package academy.user.login

import academy.user.AcademyUserControllerTrait
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.client.RestTemplate

class LoginController implements AcademyUserControllerTrait {

    @Value('${auth.url}')
    private String AUTH_URL

    def jwtAuthProviderService

    def restTemplate = new RestTemplate()

    def auth() {
        def credentials = [email: params.username, password: params.password]
        def headers = ['Content-Type' : 'application/json']

        def response = restTemplate.postForObject(AUTH_URL, credentials, String.class, headers)

        String token = response.body

        try {
            def authentication = new UsernamePasswordAuthenticationToken(token, credentials)

            jwtAuthProviderService.authenticate(authentication)
        } catch(Exception e) {
            flash.message = "Invalid email or password"
        }
    }
}
