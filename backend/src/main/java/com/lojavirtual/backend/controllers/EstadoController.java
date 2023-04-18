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

import com.lojavirtual.backend.domain.dtos.EstadoDTO;
import com.lojavirtual.backend.services.EstadoService;

@RestController
@RequestMapping(value = "/api/estados")
public class EstadoController {

  @Autowired
  private EstadoService service;

  @PostMapping(value = "/criar")
  public ResponseEntity<EstadoDTO> create(@RequestBody EstadoDTO estado) {
    EstadoDTO criarEstado = service.create(estado);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarEstado.getId()).toUri();
    return ResponseEntity.created(uri).body(criarEstado);
  }

  @DeleteMapping(value = "/{id}")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<EstadoDTO>> findAll() {
    List<EstadoDTO> todosEstados = service.findAll();

    return ResponseEntity.ok(todosEstados);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<EstadoDTO> findById(@PathVariable Integer id) {
    EstadoDTO estado = service.findById(id);

    return ResponseEntity.ok().body(estado);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<EstadoDTO> update(@RequestBody EstadoDTO estado, @PathVariable Integer id) {
    EstadoDTO atualizarEstado = service.update(estado, id);

    return ResponseEntity.ok().body(atualizarEstado);
  }
  
}
