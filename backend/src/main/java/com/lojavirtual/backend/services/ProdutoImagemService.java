package com.lojavirtual.backend.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lojavirtual.backend.domain.dtos.ProdutoImagemDTO;
import com.lojavirtual.backend.domain.models.Produto;
import com.lojavirtual.backend.domain.models.ProdutoImagem;
import com.lojavirtual.backend.repositories.ProdutoImagemRepository;
import com.lojavirtual.backend.repositories.ProdutoRepository;
import com.lojavirtual.backend.services.exceptions.FileStorageException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoImagemService {

  @Autowired
  private ProdutoImagemRepository repository;

  @Autowired
  private ProdutoRepository produtoRepository;

  public ProdutoImagemDTO upload(Integer id, MultipartFile file) {
    Produto produto = produtoRepository.findById(id).get();
    ProdutoImagem objeto = new ProdutoImagem();

    if(produto == null) {
      throw new ObjectNotFoundException(String.format("Produto com id: %d não encontrado", produto));
    }

    try {
      if(!file.isEmpty()) {
        byte[] bytes = file.getBytes();
        String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
				Path caminho = Paths.get("C:/Code/UploadDir" + nomeImagem);

				Files.write(caminho, bytes);
        objeto.setNome(nomeImagem);
      }
    } catch (Exception e) {
      throw new FileStorageException(
        "Não foi possível armazenar o arquivo. Por favor, tente novamente!", e);
    }

    objeto.setProduto(produto);
    objeto = repository.save(objeto);

    ProdutoImagemDTO dto = new ProdutoImagemDTO(objeto);
    
    return dto;
  }
  
}
