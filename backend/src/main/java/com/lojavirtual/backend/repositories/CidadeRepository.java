package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

  Optional<Cidade> findByNome(String nome);

}
