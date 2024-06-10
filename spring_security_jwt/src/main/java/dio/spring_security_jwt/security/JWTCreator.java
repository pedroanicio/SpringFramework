package dio.spring_security_jwt.security;



import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;

public class JWTCreator {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";


    public static String create(String prefix, SecretKey key, JWTObject jwtObject) {
        String token = Jwts
                .builder()
                .subject(jwtObject.getSubject())
                .issuedAt(jwtObject.getIssuedAt())
                .expiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
                .signWith(key).compact();
        return prefix + " " + token;
    }

    public static JWTObject create(String token, String prefix, SecretKey key) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException {
        JWTObject object = new JWTObject();

        token = token.replace(prefix + " ", "");
        Jws<Claims> claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token);

        object.setSubject(claims.getPayload().getSubject());
        object.setExpiration(claims.getPayload().getExpiration());
        object.setIssuedAt(claims.getPayload().getIssuedAt());
        object.setRoles((List<String>)claims.getPayload().get(ROLES_AUTHORITIES));


        return object;
    }

    private static List<String> checkRoles(List<String> roles) {
        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_",""))).collect(Collectors.toList());
    }

}