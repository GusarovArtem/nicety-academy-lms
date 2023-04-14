package academy.jwt

import academy.user.AcademyUser
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder

class JwtAuthProviderService implements AuthenticationProvider {

    @Value('${auth.url}')
    private String AUTH_URL

    def restTemplate

    def jwtValidatorService

    @Override
    Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.principal
        def credentials = [email: email,
                                                    password: authentication.credentials]

        ResponseEntity<JwtResponse> response = restTemplate.postForEntity(AUTH_URL, credentials, JwtResponse.class);
        String token = response.getBody()?.getToken()

        if (jwtValidatorService.validate(token)) {
            AcademyUser user = AcademyUser.findByEmail(email)
            authentication = new UsernamePasswordAuthenticationToken(user, null, user.authorities())
            SecurityContextHolder.getContext().setAuthentication(authentication)

            return authentication
        } else {
            throw new BadCredentialsException("Invalid email or password")
        }
    }

    @Override
    boolean supports(Class<?> authentication) {
        // Indicate whether this authentication provider supports the provided authentication token
        // In this case, you can return true for any authentication token since JWT is independent of token type
        return true
    }
}
