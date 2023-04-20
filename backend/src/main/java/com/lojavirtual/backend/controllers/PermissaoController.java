package com.lojavirtual.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.backend.domain.dtos.PermissaoDTO;
import com.lojavirtual.backend.domain.models.Permissao;
import com.lojavirtual.backend.services.PermissaoService;

@RestController
@RequestMapping(value = "/api/permissoes")
public class PermissaoController {

  @Autowired
  private PermissaoService service;

  @PostMapping(value = "/")
  public ResponseEntity<PermissaoDTO> create(@RequestBody Permissao permissao) {
    PermissaoDTO criarPermissao = service.create(permissao);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarPermissao.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarPermissao);
  }

  @DeleteMapping(value = "/{id}")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<PermissaoDTO>> findAll() {
    List<PermissaoDTO> todasPermissoes = service.findAll();

    return ResponseEntity.ok(todasPermissoes);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<PermissaoDTO> findById(@PathVariable Integer id) {
    PermissaoDTO permissao = service.findById(id);

    return ResponseEntity.ok().body(permissao);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<PermissaoDTO> update(@RequestBody Permissao permissao, @PathVariable Integer id) {
    PermissaoDTO atualizarPermissao = service.update(permissao, id);

    return ResponseEntity.ok().body(atualizarPermissao);
  }

}
