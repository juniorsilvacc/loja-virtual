package com.lojavirtual.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.models.CarrinhoCompra;
import com.lojavirtual.backend.domain.models.CarrinhoCompraItem;
import com.lojavirtual.backend.repositories.CarrinhoCompraItemRepository;
import com.lojavirtual.backend.repositories.CarrinhoCompraRepository;

@Service
public class CarrinhoCompraService {

  @Autowired
  private CarrinhoCompraRepository repository;

  @Autowired
  private CarrinhoCompraItemRepository carrinhoCompraItemRepository;

  // @Autowired
  // private UsuarioClienteRepository usuarioClienteRepository;

  // @Autowired
  // private EnderecoRepository enderecoClienteRepository;

  public CarrinhoCompra addicionarCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
    // Usuario cliente = usuarioClienteRepository.findById(carrinhoCompra.getId()).get();
    // Integer enderecoID = carrinhoCompra.getEndereco().getId();
    // Endereco enderecoCliente = enderecoClienteRepository.findById(enderecoID).get();

    // if(cliente == null) {
    //   throw new ObjectNotFoundException("Cliente não encontrado");
    // }

    // if(enderecoCliente == null) {
    //   throw new ObjectNotFoundException("Endereço não encontrado");
    // }

    carrinhoCompra.setDataCompra(new Date());
    CarrinhoCompra salvarCarrinho = repository.save(carrinhoCompra);
    
    return salvarCarrinho;
  }

  public CarrinhoCompraItem addItemCarrinho(CarrinhoCompraItem carrinhoCompraItem) {
    CarrinhoCompraItem addItem = carrinhoCompraItemRepository.save(carrinhoCompraItem);
  
    return addItem;
  }

  public CarrinhoCompra findById(Integer id) {
    CarrinhoCompra carrinhoCompra = repository.findById(id).get();
   
    return carrinhoCompra;
  }

}
