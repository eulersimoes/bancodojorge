package br.com.bancodojorge.apirest.infrastructure.util;

import br.com.bancodojorge.apirest.domain.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JWTUtil {
    private Long expiration = 6000000l;

    @Value("${jwt.secret}")
    private String secret;


}
