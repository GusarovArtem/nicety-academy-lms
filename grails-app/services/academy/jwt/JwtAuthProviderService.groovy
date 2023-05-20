package academy.jwt


import academy.user.AcademyUser
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.transaction.annotation.Transactional

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class JwtAuthProviderService implements AuthenticationProvider {

    @Value('${auth.url}')
    private String AUTH_URL

    @Value('${auth.header}')
    private String AUTH_HEADER

    def restTemplate

    def jwtValidatorService

    @Override
    @Transactional
    Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String email = authentication.principal
        final String password = authentication.credentials

        /* JWT generation on auth microservice */
        final String token = sendAuthRequest(email, password)?.body()

        /*  JWT validation
         *      On success:  set authentication for user
         *      On failure:  throw BadCredentialsException */
        return validateToken(authentication, token)
    }

    @Override
    boolean supports(Class<?> authentication) {
        /*  Indicate is authentication provider supports the provided authentication token
         *  We return true for any authentication token since JWT is independent of token type */
        return true
    }

    private final sendAuthRequest(String email, String password) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(AUTH_URL))
                .header(AUTH_HEADER, getBasicAuthenticationHeader(email, password))
                .build()

        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (ConnectException e) {
            log.error("Auth microservice is not available!", e)
        }
    }

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    private Authentication validateToken(Authentication authentication, String token) {
        String email = authentication.principal

        try {
            if (jwtValidatorService.validate(token, email)) {
                AcademyUser.withTransaction {
                    final AcademyUser user = AcademyUser.findByEmail(email)

                    authentication = new UsernamePasswordAuthenticationToken(user, null, user.authorities())
                    SecurityContextHolder.getContext().setAuthentication(authentication)
                }
                return authentication
            }
        } catch (Exception e) {
            log.error("During sign in for $email: ", e)
        }
        throw new BadCredentialsException("Bad credentials")
    }
}
