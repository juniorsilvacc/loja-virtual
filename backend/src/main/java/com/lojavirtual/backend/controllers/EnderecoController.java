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

import com.lojavirtual.backend.domain.dtos.EnderecoDTO;
import com.lojavirtual.backend.domain.models.Endereco;
import com.lojavirtual.backend.services.EnderecoService;

@RestController
@RequestMapping(value = "/api/enderecos")
public class EnderecoController {

  @Autowired
  private EnderecoService service;

  @PostMapping(value = "/")
  public ResponseEntity<EnderecoDTO> create(@RequestBody Endereco endereco) {
    EnderecoDTO criarEndereco = service.create(endereco);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarEndereco.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarEndereco);
  }

  @DeleteMapping(value = "/{id}")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<EnderecoDTO>> findAll() {
    List<EnderecoDTO> todasEnderecos = service.findAll();

    return ResponseEntity.ok(todasEnderecos);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<EnderecoDTO> findById(@PathVariable Integer id) {
    EnderecoDTO enderecos = service.findById(id);

    return ResponseEntity.ok().body(enderecos);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<EnderecoDTO> update(@RequestBody Endereco endereco, @PathVariable Integer id) {
    EnderecoDTO atualizarEndereco = service.update(endereco, id);

    return ResponseEntity.ok().body(atualizarEndereco);
  }

}
