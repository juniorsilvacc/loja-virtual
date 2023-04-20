package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

  Optional<Produto> findByDescricaoCurta(String descricaoCurta);

}
