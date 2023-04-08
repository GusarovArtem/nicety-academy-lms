package academy.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails

import java.util.function.Function

class JwtValidatorService {

    @Value('${auth.jwt.secret}')
    private String jwtSecret

    Boolean validate(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token)
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token))
    }

    String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject)
    }

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token)
        return claimsResolver.apply(claims)
    }

    Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt)
    }

    Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration)
    }


    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody()
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token)
        return expiration.before(new Date())
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false
    }

    Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token))
    }

}

