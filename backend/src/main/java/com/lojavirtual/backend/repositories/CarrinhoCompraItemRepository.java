package com.lojavirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.CarrinhoCompraItem;

public interface CarrinhoCompraItemRepository extends JpaRepository<CarrinhoCompraItem, Integer>{
  
}
