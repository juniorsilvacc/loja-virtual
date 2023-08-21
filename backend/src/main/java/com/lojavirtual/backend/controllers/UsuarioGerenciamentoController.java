package com.lojavirtual.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.services.UsuarioGerenciamentoService;

@RestController
@RequestMapping(value = "/api/usuarios/usuario-gerenciamento")
public class UsuarioGerenciamentoController {

  @Autowired
  private UsuarioGerenciamentoService service;

  @PostMapping(value = "/solicitar-senha")
  public String solicitarSenha(@RequestBody Usuario usuario) {
    return service.solicitarSenha(usuario.getEmail());
  }

  @PostMapping(value = "/alterar-senha")
  public String alterarSenha(@RequestBody Usuario usuario) {
    return service.alterarSenha(usuario);
  }

}
