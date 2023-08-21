package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

  Optional<Estado> findByNome(String nome);

}
