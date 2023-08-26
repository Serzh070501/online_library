package org.library.config.security;



import io.jsonwebtoken.*;
import org.library.config.AppProperties;
import org.library.service.auth.JWTUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JWTTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JWTTokenProvider.class);

    private final AppProperties appProperties;

    public JWTTokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }


    public String createToken(final Authentication authentication) {
        final JWTUser userPrincipal = (JWTUser) authentication.getPrincipal();
        final Date now = new Date();
        final Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                .claim("roles", authentication.getAuthorities())
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }

    public UUID getUserIdFromToken(final String token) {
        final Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

        return UUID.fromString(claims.getSubject());
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(final String authToken) {
        try {
            Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        } catch (final SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (final MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (final ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (final UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (final IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}
