package com.lojavirtual.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.backend.domain.dtos.ProdutoImagemDTO;
import com.lojavirtual.backend.domain.models.ProdutoImagem;
import com.lojavirtual.backend.services.ProdutoImagemService;

@RestController
@RequestMapping(value = "/api/produtos/imagem")
@EnableMethodSecurity(prePostEnabled = true)
public class ProdutoImagemController {

  @Autowired
  private ProdutoImagemService service;

  @PostMapping(value = "/upload/")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<ProdutoImagemDTO> upload(@RequestParam("id") Integer id,
      @RequestParam("file") MultipartFile file) {
    ProdutoImagemDTO uploadImagem = service.upload(id, file);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(uploadImagem.getId())
        .toUri();
    return ResponseEntity.created(uri).body(uploadImagem);
  }

  @GetMapping("/")
  public List<ProdutoImagem> buscarTodos() {
    return service.buscarTodos();
  }

  @GetMapping("/{id}")
  public List<ProdutoImagem> buscarProduto(@PathVariable Integer id) {
    return service.buscarProduto(id);
  }

}
