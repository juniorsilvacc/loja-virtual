package com.lojavirtual.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.services.UsuarioGerenciamentoService;

@RestController
@RequestMapping(value = "/api/usuarios-gerenciamentos")
public class UsuarioGerenciamentoController {

  @Autowired
  private UsuarioGerenciamentoService service;

  @PostMapping(value = "/solicitar-senha")
  public String solicitarSenha(@RequestBody Usuario Usuario) {
    return service.solicitarSenha(Usuario.getEmail());
  }

  @PostMapping(value = "/alterar-senha")
  public String alterarSenha(@RequestBody Usuario Usuario) {
    return service.alterarSenha(Usuario);
  }
  
}
