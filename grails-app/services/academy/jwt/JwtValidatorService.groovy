package academy.jwt

import academy.user.AcademyUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.SignatureException
import org.springframework.beans.factory.annotation.Value

import java.util.function.Function

class JwtValidatorService {

    @Value('${auth.jwt.secret}')
    private String JWT_SECRET

    @Value('${auth.jwt.algorithm}')
    private String JWT_ALGORITHM

    Boolean validate(String token) {
        final String email = getUserEmailFromToken(token)

        return (AcademyUser.findByEmail(email)  && !isTokenExpired(token))
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
        try {
            return Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody()
        } catch (ExpiredJwtException ex) {
            throw new JwtException("Token has expired", ex)
        } catch (UnsupportedJwtException ex) {
            throw new JwtException("Unsupported token", ex)
        } catch (MalformedJwtException ex) {
            throw new JwtException("Malformed token", ex)
        } catch (SignatureException ex) {
            throw new JwtException("Invalid token signature", ex)
        } catch (IllegalArgumentException ex) {
            throw new JwtException("Invalid token", ex)
        }
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

