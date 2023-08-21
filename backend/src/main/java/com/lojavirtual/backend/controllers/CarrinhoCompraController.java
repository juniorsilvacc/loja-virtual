package com.lojavirtual.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.backend.domain.models.CarrinhoCompra;
import com.lojavirtual.backend.domain.models.CarrinhoCompraItem;
import com.lojavirtual.backend.services.CarrinhoCompraService;

@RestController
@RequestMapping(value = "/api/carrinho-compra")
public class CarrinhoCompraController {

  @Autowired
  private CarrinhoCompraService service;

  @PostMapping(value = "/")
  public ResponseEntity<CarrinhoCompra> addicionarCarrinhoCompra(@RequestBody CarrinhoCompra carrinhoCompra) {
    CarrinhoCompra carrinhoCompraSalve = service.addicionarCarrinhoCompra(carrinhoCompra);
    return ResponseEntity.created(null).body(carrinhoCompraSalve);
  }

  @PostMapping(value = "/add-item/carrinho")
  public ResponseEntity<CarrinhoCompraItem> addItemCarrinho(@RequestBody CarrinhoCompraItem carrinhoCompraItem) {
    CarrinhoCompraItem addItem = service.addItemCarrinho(carrinhoCompraItem);
    
    return ResponseEntity.created(null).body(addItem);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CarrinhoCompra> findById(@PathVariable Integer id) {
    CarrinhoCompra carrinhoCompra = service.findById(id);

    return ResponseEntity.ok().body(carrinhoCompra);
  }

}
