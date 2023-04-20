package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.ProdutoDTO;
import com.lojavirtual.backend.domain.models.Produto;
import com.lojavirtual.backend.repositories.ProdutoRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository repository;

  public ProdutoDTO create(Produto produto) {
    Optional<Produto> nomeProduto = repository.findByDescricaoCurta(produto.getDescricaoCurta());

    if(nomeProduto.isPresent()) {
      throw new DataIntegrityViolationException("A descrição desse produto já existe");
    }

    Produto salvarProduto = repository.save(produto);
    
    ProdutoDTO dto = new ProdutoDTO(salvarProduto);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Produto> idProduto = repository.findById(id);

    if(!idProduto.isPresent()) {
      throw new ObjectNotFoundException(String.format("Produto com id: %d não encontrado", id));
    }

    repository.deleteById(id);
  }

  public List<ProdutoDTO> findAll() {
    List<Produto> todasProdutos = repository.findAll();
    List<ProdutoDTO> dto = todasProdutos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    return dto;
  }

  public ProdutoDTO findById(Integer id) {
    Produto produto = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Produto com id: %d não encontrado", id)));

    ProdutoDTO dto = new ProdutoDTO(produto);

    return dto;
  }

  public ProdutoDTO update(Produto produto, Integer id) {
    Optional<Produto> oldProduto = repository.findById(id);

    if(!oldProduto.isPresent()) {
      System.out.println("Produto não encontrado");
    }

    BeanUtils.copyProperties(produto, oldProduto.get(), "id");

    Produto salvarProduto = repository.save(oldProduto.get());
    
    ProdutoDTO dto = new ProdutoDTO(salvarProduto);
 
    return dto;
  }
  
}
