package com.lojavirtual.backend.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.backend.domain.dtos.CarrinhoCompraDTO;
import com.lojavirtual.backend.domain.dtos.CarrinhoCompraItemDTO;
import com.lojavirtual.backend.domain.models.CarrinhoCompra;
import com.lojavirtual.backend.domain.models.CarrinhoCompraItem;
import com.lojavirtual.backend.services.CarrinhoCompraService;

@RestController
@RequestMapping(value = "/api/carrinho-compra")
public class CarrinhoCompraController {

  @Autowired
  private CarrinhoCompraService service;

  @PostMapping(value = "/")
  public ResponseEntity<CarrinhoCompraDTO> addicionarCarrinhoCompra(@RequestBody CarrinhoCompra carrinhoCompra) {
    CarrinhoCompraDTO carrinhoCompraSalve = service.addicionarCarrinhoCompra(carrinhoCompra);
    return ResponseEntity.created(null).body(carrinhoCompraSalve);
  }

  @PostMapping(value = "/add-item/carrinho")
  public ResponseEntity<CarrinhoCompraItemDTO> addItemCarrinho(@RequestBody CarrinhoCompraItem carrinhoCompraItem) {
    CarrinhoCompraItemDTO addItem = service.addItemCarrinho(carrinhoCompraItem);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addItem.getId())
        .toUri();
    return ResponseEntity.created(uri).body(addItem);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CarrinhoCompraDTO> findById(@PathVariable Integer id) {
    CarrinhoCompraDTO carrinhoCompra = service.findById(id);

    return ResponseEntity.ok().body(carrinhoCompra);
  }

}
