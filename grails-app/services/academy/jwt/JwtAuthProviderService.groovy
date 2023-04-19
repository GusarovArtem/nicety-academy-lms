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
        String email = authentication.principal
        String password = authentication.credentials

        String token = sendAuthRequest(email, password)?.body()

        if (jwtValidatorService.validate(token, email)) {
            AcademyUser.withTransaction {
                final AcademyUser user = AcademyUser.findByEmail(email)

                authentication = new UsernamePasswordAuthenticationToken(user, null, user.authorities())
                SecurityContextHolder.getContext().setAuthentication(authentication)

                return authentication
            }
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

    private final sendAuthRequest(String email, String password) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(AUTH_URL))
                .header(AUTH_HEADER, getBasicAuthenticationHeader(email, password))
                .build()

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
