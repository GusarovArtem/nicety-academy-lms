package academy.jwt

import academy.user.AcademyUser
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder

class JwtAuthProviderService implements AuthenticationProvider {

    def jwtValidatorService

    @Override
    Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();

        boolean valid = jwtValidatorService.validate(token);

        if (valid) {
            String email = jwtValidatorService.getUserEmailFromToken(token);
            AcademyUser user = AcademyUser.findByEmail(email);

            Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(user, null, user.authorities());

            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

            return authenticatedUser;
        } else {
            throw new BadCredentialsException("Invalid JWT token");
        }
    }

    @Override
    boolean supports(Class<?> authentication) {
        // Indicate whether this authentication provider supports the provided authentication token
        // In this case, you can return true for any authentication token since JWT is independent of token type
        return true;
    }
}
