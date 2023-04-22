package com.lojavirtual.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.domain.models.Usuario;

public interface UsuarioClienteRepository extends JpaRepository<Usuario, Integer>{

  Optional<Usuario> findByEmail(String email);
  Optional<Usuario> findByCpf(String cpf);

}
