package com.lojavirtual.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.ProdutoImagem;

public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagem, Integer>{

  List<ProdutoImagem> findByProdutoId(Integer id);
  
}
