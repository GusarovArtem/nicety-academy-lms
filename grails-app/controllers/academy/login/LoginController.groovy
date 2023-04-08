package academy.login

import academy.jwt.JwtValidatorService
import academy.user.AcademyUser
import academy.user.AcademyUserControllerTrait
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.client.RestTemplate

class LoginController implements AcademyUserControllerTrait {

    @Value('${auth.url}')
    private String AUTH_URL

    @Value('${auth.jwt.secret}')
    private String JWT_SECRET

    @Value('${auth.jwt.algorithm}')
    private String JWT_ALGORITHM

    def restTemplate = new RestTemplate()

    def authenticate(String email, String password) {
        def credentials = [email: email, password: password]

        def response = restTemplate.postForEntity(AUTH_URL, credentials, String.class)

        String token = response.body

        def jwtValidator = new JwtValidatorService(JWT_SECRET, JWT_ALGORITHM)
        boolean valid = jwtValidator.validate(token)

        if (valid) {
            AcademyUser user = AcademyUser.findByEmail(email)
            def authentication = new UsernamePasswordAuthenticationToken(user, null, user.authorities())
            SecurityContextHolder.getContext().setAuthentication(authentication)
        } else {
            flash.message = "Invalid email or password"
            redirect(action: "index")
        }
    }
}
