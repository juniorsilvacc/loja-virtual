package com.lojavirtual.backend.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.backend.domain.dtos.ProdutoImagemDTO;
import com.lojavirtual.backend.services.ProdutoImagemService;

@RestController
@RequestMapping(value = "/api/produtos/imagem")
public class ProdutoImagemController {
  
  @Autowired
  private ProdutoImagemService service;

  @PostMapping(value = "/upload/")
  public ResponseEntity<ProdutoImagemDTO> upload(@RequestParam("id") Integer id, @RequestParam("file") MultipartFile file) {
    ProdutoImagemDTO uploadImagem = service.upload(id, file);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(uploadImagem.getId())
        .toUri();
    return ResponseEntity.created(uri).body(uploadImagem);
  }

}
