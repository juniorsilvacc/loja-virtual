package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

  Optional<Marca> findByNome(String nome);

}
