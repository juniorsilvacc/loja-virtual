package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.PermissaoDTO;
import com.lojavirtual.backend.domain.models.Permissao;
import com.lojavirtual.backend.repositories.PermissaoRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoService {

  @Autowired
  private PermissaoRepository repository;

  public PermissaoDTO create(Permissao permissao) {
    Permissao nomePermissao = repository.findByNome(permissao.getNome());

    if(nomePermissao != null) {
      throw new DataIntegrityViolationException("Essa permissão já existe");
    }

    Permissao salvarPermissao = repository.save(permissao);
    
    PermissaoDTO dto = new PermissaoDTO(salvarPermissao);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Permissao> idPermissao = repository.findById(id);

    if(!idPermissao.isPresent()) {
      throw new ObjectNotFoundException(String.format("Permissão com id: %d não encontrada", id));
    }

    repository.deleteById(id);
  }

  public List<PermissaoDTO> findAll() {
    List<Permissao> todasPermissaos = repository.findAll();
    List<PermissaoDTO> dto = todasPermissaos.stream().map(PermissaoDTO::new).collect(Collectors.toList());
    return dto;
  }

  public PermissaoDTO findById(Integer id) {
    Permissao permissao = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Permissão com id: %d não encontrada", id)));

    PermissaoDTO dto = new PermissaoDTO(permissao);

    return dto;
  }

  public PermissaoDTO update(Permissao permissao, Integer id) {
    Optional<Permissao> oldPermissao = repository.findById(id);

    if(!oldPermissao.isPresent()) {
      throw new ObjectNotFoundException(String.format("Permissão com id: %d não encontrada", id));
    }

    BeanUtils.copyProperties(permissao, oldPermissao.get(), "id");

    Permissao salvarPermissao = repository.save(oldPermissao.get());
    
    PermissaoDTO dto = new PermissaoDTO(salvarPermissao);
 
    return dto;
  }
  
}
