package com.lojavirtual.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.backend.domain.dtos.UsuarioDTO;
import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuarios/funcionarios")
@EnableMethodSecurity(prePostEnabled = true)
public class UsuarioController {

  @Autowired
  private UsuarioService service;

  @PostMapping(value = "/")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<UsuarioDTO> create(@RequestBody Usuario usuario) {
    UsuarioDTO criarUsuario = service.create(usuario);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarUsuario.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarUsuario);
  }

  @DeleteMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<List<UsuarioDTO>> findAll() {
    List<UsuarioDTO> todosUsuarios = service.findAll();

    return ResponseEntity.ok(todosUsuarios);
  }

  @GetMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
    UsuarioDTO usuario = service.findById(id);

    return ResponseEntity.ok().body(usuario);
  }

  @PutMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<UsuarioDTO> update(@RequestBody Usuario usuario, @PathVariable Integer id) {
    UsuarioDTO atualizarUsuario = service.update(usuario, id);

    return ResponseEntity.ok().body(atualizarUsuario);
  }

}
