package br.com.template.jwt;

import br.com.template.dao.IJwtDAO;
import br.com.template.exception.InvalidTokenException;
import br.com.template.exception.TokenNotFoundException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;


@Service
public class TokenUtil {

    @Autowired
    @Qualifier("HEADER_AUTHORIZATION")
    private String AUTH_HEADER_NAME;

    @Autowired
    private IJwtDAO iJWTDAO;


    public Authentication verifyToken(HttpServletRequest request, boolean urlAuthenticationNeeded) throws Exception {
        final String token = request.getHeader(AUTH_HEADER_NAME);

        if(token.equals(iJWTDAO.getReferenciedBy(token, urlAuthenticationNeeded).getToken())){
      		 return new UserAuthentication();
      	}
        throw new TokenNotFoundException("Cabeçalho "+AUTH_HEADER_NAME+" nao encontrado !");
    }

    public boolean isTokenValid(String token) throws InvalidTokenException, UnsupportedEncodingException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(iJWTDAO.getKey().getToken());
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception ex){
            throw new InvalidTokenException(ex.getMessage());
        }
    }

    public Claims getClaims(String token) throws Exception {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(iJWTDAO.getKey().getToken())
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        }catch(JwtException ex){
            throw new JwtException(ex.getMessage());
        }
    }

    public String getToken(HttpServletRequest request) throws TokenNotFoundException{
        final String token = request.getHeader(AUTH_HEADER_NAME);

        if(token != null && !token.isEmpty()){
            return token;
        }
        throw new TokenNotFoundException("Cabeçalho "+AUTH_HEADER_NAME+" nao encontrado !");
    }


}
