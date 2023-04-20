package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

  Optional<Categoria> findByNome(String nome);

}
