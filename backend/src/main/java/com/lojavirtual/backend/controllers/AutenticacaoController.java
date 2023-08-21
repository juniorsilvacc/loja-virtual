package com.lojavirtual.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.backend.domain.dtos.security.CredenciaisDTO;
import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.security.JwtUtil;
import com.lojavirtual.backend.services.exceptions.InvalidAuthenticationException;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoController {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  AuthenticationManager authenticationManager;

  @PostMapping(value = "/login")
  public ResponseEntity<?> login(@RequestBody CredenciaisDTO usuario) {
    if (usuario == null || usuario.getEmail() == null || usuario.getEmail().isBlank()
        || usuario.getSenha() == null || usuario.getSenha().isBlank()) {
      throw new InvalidAuthenticationException("Solicitação de usuário inválida");
    }

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    Usuario autenticado = (Usuario) authentication.getPrincipal();

    String token = jwtUtil.gerarToken(autenticado);

    return ResponseEntity.ok().body(token);
  }

}
