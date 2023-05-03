package com.lojavirtual.backend.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.lojavirtual.backend.domain.models.Usuario;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {

  private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

  // @Value("${jwt.expiration}")
  private Integer expiration = 604800000;

  // @Value("${jwt.secret}")
  private String secret = "StringUsadaParaGerarToken";

  public String gerarToken(Usuario usuario) {
    return Jwts.builder()
        .setSubject(usuario.getEmail())
        .claim("roles", usuario.getRoles())
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public boolean validarToken(String token, HttpServletRequest request) {
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (SignatureException e) {
      logger.error("Assinatura Inválida", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("Token expirado", e.getMessage());
      request.setAttribute("validacaoToken", "Token expirado");
    } catch (UnsupportedJwtException e) {
      logger.error("Token não suportado", e.getMessage());
    }

    return false;
  }

  public String getToken(HttpServletRequest request) {
    String headerToken = request.getHeader("Authorization");
    if (StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer ")) {
      return headerToken.replace("Bearer ", "");
    }
    return null;
  }

  public String getEmail(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }

}
