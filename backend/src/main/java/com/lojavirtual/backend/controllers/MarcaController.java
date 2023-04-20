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

import com.lojavirtual.backend.domain.dtos.MarcaDTO;
import com.lojavirtual.backend.domain.models.Marca;
import com.lojavirtual.backend.services.MarcaService;

@RestController
@RequestMapping(value = "/api/marcas")
public class MarcaController {

  @Autowired
  private MarcaService service;

  @PostMapping(value = "/")
  public ResponseEntity<MarcaDTO> create(@RequestBody Marca marca) {
    MarcaDTO criarMarca = service.create(marca);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarMarca.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarMarca);
  }

  @DeleteMapping(value = "/{id}")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<MarcaDTO>> findAll() {
    List<MarcaDTO> todasMarcas = service.findAll();

    return ResponseEntity.ok(todasMarcas);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<MarcaDTO> findById(@PathVariable Integer id) {
    MarcaDTO marca = service.findById(id);

    return ResponseEntity.ok().body(marca);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<MarcaDTO> update(@RequestBody Marca marca, @PathVariable Integer id) {
    MarcaDTO atualizarMarca = service.update(marca, id);

    return ResponseEntity.ok().body(atualizarMarca);
  }

}
