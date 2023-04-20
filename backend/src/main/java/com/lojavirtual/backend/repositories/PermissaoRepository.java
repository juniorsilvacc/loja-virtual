package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer>{

  Optional<Permissao> findByNome(String nome);

}
