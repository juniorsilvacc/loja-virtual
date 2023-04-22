package com.lojavirtual.backend.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.backend.domain.dtos.UsuarioClienteDTO;
import com.lojavirtual.backend.domain.dtos.UsuarioDTO;
import com.lojavirtual.backend.services.UsuarioClienteService;

@RestController
@RequestMapping(value = "/api/usuarios/clientes")
public class UsuarioClienteController {

  @Autowired
  private UsuarioClienteService service;

  @PostMapping(value = "/")
  public ResponseEntity<UsuarioDTO> register(@RequestBody UsuarioClienteDTO usuarioClienteDTO) {
    UsuarioDTO registrarCliente = service.register(usuarioClienteDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(registrarCliente.getId())
        .toUri();
    return ResponseEntity.created(uri).body(registrarCliente);
  }
  
}
