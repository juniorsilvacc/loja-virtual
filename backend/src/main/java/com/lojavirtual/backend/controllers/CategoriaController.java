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

import com.lojavirtual.backend.domain.dtos.CategoriaDTO;
import com.lojavirtual.backend.domain.models.Categoria;
import com.lojavirtual.backend.services.CategoriaService;

@RestController
@RequestMapping(value = "/api/categorias")
@EnableMethodSecurity(prePostEnabled = true)
public class CategoriaController {

  @Autowired
  private CategoriaService service;

  @PostMapping(value = "/")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<CategoriaDTO> create(@RequestBody Categoria categoria) {
    CategoriaDTO criarCategoria = service.create(categoria);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarCategoria.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarCategoria);
  }

  @DeleteMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<CategoriaDTO>> findAll() {
    List<CategoriaDTO> todasCategorias = service.findAll();

    return ResponseEntity.ok(todasCategorias);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
    CategoriaDTO categoria = service.findById(id);

    return ResponseEntity.ok().body(categoria);
  }

  @PutMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<CategoriaDTO> update(@RequestBody Categoria categoria, @PathVariable Integer id) {
    CategoriaDTO atualizarCategoria = service.update(categoria, id);

    return ResponseEntity.ok().body(atualizarCategoria);
  }

}
