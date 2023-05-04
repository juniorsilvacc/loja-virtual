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

import com.lojavirtual.backend.domain.dtos.ProdutoDTO;
import com.lojavirtual.backend.domain.models.Produto;
import com.lojavirtual.backend.services.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos")
@EnableMethodSecurity(prePostEnabled = true)
public class ProdutoController {

  @Autowired
  private ProdutoService service;

  @PostMapping(value = "/")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<ProdutoDTO> create(@RequestBody Produto produto) {
    ProdutoDTO criarProduto = service.create(produto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarProduto.getId())
        .toUri();
    return ResponseEntity.created(uri).body(criarProduto);
  }

  @DeleteMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void remove(@PathVariable Integer id) {
    service.remove(id);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<ProdutoDTO>> findAll() {
    List<ProdutoDTO> todosProdutos = service.findAll();

    return ResponseEntity.ok(todosProdutos);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
    ProdutoDTO produto = service.findById(id);

    return ResponseEntity.ok().body(produto);
  }

  @PutMapping(value = "/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<ProdutoDTO> update(@RequestBody Produto produto, @PathVariable Integer id) {
    ProdutoDTO atualizarProduto = service.update(produto, id);

    return ResponseEntity.ok().body(atualizarProduto);
  }
  
}
