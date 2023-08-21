package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.EnderecoDTO;
import com.lojavirtual.backend.domain.models.Endereco;
import com.lojavirtual.backend.repositories.EnderecoRepository;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository repository;

  public EnderecoDTO create(Endereco endereco) {    
    Endereco enderecoSalvo = repository.save(endereco);
    
    EnderecoDTO dto = new EnderecoDTO(enderecoSalvo);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Endereco> idEndereco = repository.findById(id);

    if(!idEndereco.isPresent()) {
      throw new ObjectNotFoundException(String.format("Endereco com id: %d não encontrado", id));
    }

    repository.deleteById(id);
  }

  public List<EnderecoDTO> findAll() {
    List<Endereco> todosEnderecos = repository.findAll();
    List<EnderecoDTO> dto = todosEnderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
    return dto;
  }

  public EnderecoDTO findById(Integer id) {
    Endereco endereco = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Endereco com id: %d não encontrado", id)));

    EnderecoDTO dto = new EnderecoDTO(endereco);

    return dto;
  }

  public EnderecoDTO update(Endereco endereco, Integer id) {
    Optional<Endereco> oldEndereco = repository.findById(id);

    if(!oldEndereco.isPresent()) {
      throw new ObjectNotFoundException(String.format("Endereco com id: %d não encontrado", id));
    }

    BeanUtils.copyProperties(endereco, oldEndereco.get(), "id");

    Endereco salvarEndereco = repository.save(oldEndereco.get());
    
    EnderecoDTO dto = new EnderecoDTO(salvarEndereco);
 
    return dto;
  }
  
}
