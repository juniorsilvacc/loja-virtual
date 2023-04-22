package com.lojavirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer>{

  Permissao findByNome(String nome);

}
