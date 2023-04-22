package academy.jwt


import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value

import java.util.function.Function

class JwtValidatorService {

    @Value('${auth.jwt.secret}')
    private String JWT_SECRET

    @Value('${auth.jwt.algorithm}')
    private String JWT_ALGORITHM

    Boolean validate(String token, String enteredEmail) {
        final String tokenEmail = getUserEmailFromToken(token)
        boolean emailsEqual = tokenEmail == enteredEmail

        return (emailsEqual && !isTokenExpired(token))
    }

    String getUserEmailFromToken(String token) {
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


    private Claims getAllClaimsFromToken(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()

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

