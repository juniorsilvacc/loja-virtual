package com.lojavirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.CarrinhoCompra;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Integer>{
  
}
