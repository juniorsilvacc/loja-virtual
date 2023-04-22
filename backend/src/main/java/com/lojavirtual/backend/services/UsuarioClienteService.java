package com.lojavirtual.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.UsuarioClienteDTO;
import com.lojavirtual.backend.domain.dtos.UsuarioDTO;
import com.lojavirtual.backend.domain.models.Permissao;
import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.repositories.PermissaoRepository;
import com.lojavirtual.backend.repositories.UsuarioClienteRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;

@Service
public class UsuarioClienteService {

  @Autowired
  private UsuarioClienteRepository repository;

  @Autowired
  private PermissaoRepository permissao;

  public UsuarioDTO register(UsuarioClienteDTO usuarioClienteDTO) {
    Usuario usuario = new UsuarioClienteDTO().converter(usuarioClienteDTO);
    Optional<Usuario> emailUsuario = repository.findByEmail(usuario.getEmail());
    Optional<Usuario> cpfUsuario = repository.findByCpf(usuario.getCpf());
    
    Permissao role = permissao.findByNome("ROLE_USER");

    if(emailUsuario.isPresent()) {
      throw new DataIntegrityViolationException("Esse E-mail e/ou CPF já existe");
    }

    if(cpfUsuario.isPresent()) {
      throw new DataIntegrityViolationException("Esse E-mail e/ou CPF já existe");
    }

    usuario.getPermissoes().add(role);
    Usuario salvarUsuario = repository.save(usuario);
    
    UsuarioDTO dto = new UsuarioDTO(salvarUsuario);

    return dto;
  }

}
