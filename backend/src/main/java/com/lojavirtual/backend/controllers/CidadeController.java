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

import com.lojavirtual.backend.domain.dtos.CidadeDTO;
import com.lojavirtual.backend.services.CidadeService;

@RestController
@RequestMapping(value = "/api/cidades")
public class CidadeController {

  @Autowired
  private CidadeService service;

  @PostMapping(value = "/")
  public ResponseEntity<CidadeDTO> create(@RequestBody CidadeDTO cidade) {
    CidadeDTO criarCidade = service.create(cidade);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarCidade.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarCidade);
  }

  @DeleteMapping(value = "/{id}")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<CidadeDTO>> findAll() {
    List<CidadeDTO> todasCidades = service.findAll();

    return ResponseEntity.ok(todasCidades);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CidadeDTO> findById(@PathVariable Integer id) {
    CidadeDTO cidades = service.findById(id);

    return ResponseEntity.ok().body(cidades);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CidadeDTO> update(@RequestBody CidadeDTO cidade, @PathVariable Integer id) {
    CidadeDTO atualizarCidade = service.update(cidade, id);

    return ResponseEntity.ok().body(atualizarCidade);
  }

}
