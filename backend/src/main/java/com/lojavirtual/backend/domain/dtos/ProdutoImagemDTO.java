package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;

import com.lojavirtual.backend.domain.models.Produto;
import com.lojavirtual.backend.domain.models.ProdutoImagem;

public class ProdutoImagemDTO implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private Integer id;
  private String nome;

  private Produto produto;

  public ProdutoImagemDTO() {
  }

  public ProdutoImagemDTO(Integer id, String nome, Produto produto) {
    this.id = id;
    this.nome = nome;
  }

  public ProdutoImagemDTO(ProdutoImagem obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.produto = obj.getProduto();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProdutoImagemDTO other = (ProdutoImagemDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
