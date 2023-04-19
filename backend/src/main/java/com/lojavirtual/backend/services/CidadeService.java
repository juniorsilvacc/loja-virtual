package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.CidadeDTO;
import com.lojavirtual.backend.domain.models.Cidade;
import com.lojavirtual.backend.domain.models.Estado;
import com.lojavirtual.backend.repositories.CidadeRepository;
import com.lojavirtual.backend.repositories.EstadoRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
  
  @Autowired
  private CidadeRepository repository;

  @Autowired
  private EstadoRepository estadoRepository;

  public CidadeDTO create(Cidade cidade) {
    Integer estadoID = cidade.getEstado().getId();
    Optional<Estado> estado = estadoRepository.findById(estadoID);

    if(!estado.isPresent()) {
      throw new ObjectNotFoundException(String.format("Estado com id: %d não encontrado", estadoID));
    }

    Optional<Cidade> nomeCidade = repository.findByNome(cidade.getNome());

    if(nomeCidade.isPresent()) {
      throw new DataIntegrityViolationException("O nome desse cidade já existe");
    }

    Cidade criar = repository.save(cidade);
    
    CidadeDTO dto = new CidadeDTO(criar);

    return dto; 
  }

  public void remove(Integer id) {
    Optional<Cidade> idCidade = repository.findById(id);

    if(!idCidade.isPresent()) {
      throw new ObjectNotFoundException(String.format("Cidade com id: %d não encontrado", id));
    }

    repository.deleteById(id);
  }

  public List<CidadeDTO> findAll() {
    List<Cidade> todosCidades = repository.findAll();
    List<CidadeDTO> dto = todosCidades.stream().map(CidadeDTO::new).collect(Collectors.toList());
    return dto;
  }

  public CidadeDTO findById(Integer id) {
    Cidade cidade = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Cidade com id: %d não encontrado", id)));

    CidadeDTO dto = new CidadeDTO(cidade);

    return dto;
  }

  public CidadeDTO update(Cidade cidade, Integer id) {
    Optional<Cidade> oldCidade = repository.findById(id);

    if(!oldCidade.isPresent()) {
      System.out.println("Cidade não encontrado");
    }

    BeanUtils.copyProperties(cidade, oldCidade.get(), "id");

    Cidade salvarCidade = repository.save(oldCidade.get());
    
    CidadeDTO dto = new CidadeDTO(salvarCidade);
 
    return dto;
  }
  
}
