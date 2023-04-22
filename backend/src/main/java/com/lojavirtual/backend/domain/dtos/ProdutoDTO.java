package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lojavirtual.backend.domain.models.Categoria;
import com.lojavirtual.backend.domain.models.Marca;
import com.lojavirtual.backend.domain.models.Produto;
import com.lojavirtual.backend.domain.models.ProdutoImagem;

public class ProdutoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String descricaoCurta;
  private String descricaoDetalhada;
  private Double valorCusto;
  private Double valorVenda;

  private Marca marca;
  private List<Categoria> categorias = new ArrayList<>();
  private List<ProdutoImagem> imagens = new ArrayList<>();
  
  public ProdutoDTO() {
  }

  public ProdutoDTO(Integer id, String descricaoCurta, String descricaoDetalhada, 
    Double valorCusto, Double valorVenda, Marca marca, List<Categoria> categorias, List<ProdutoImagem> imagens) {
    this.id = id;
    this.descricaoCurta = descricaoCurta;
    this.descricaoDetalhada = descricaoDetalhada;
    this.valorCusto = valorCusto;
    this.valorVenda = valorVenda;
    this.marca = marca;
    this.categorias = categorias;
    this.imagens = imagens;
  }

  public ProdutoDTO(Produto obj) {
    this.id = obj.getId();
    this.descricaoCurta = obj.getDescricaoCurta();
    this.descricaoDetalhada = obj.getDescricaoDetalhada();
    this.valorCusto = obj.getValorCusto();
    this.valorVenda = obj.getValorVenda();
    this.marca = obj.getMarca();
    this.categorias = obj.getCategorias();
    this.imagens = obj.getImagens();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricaoCurta() {
    return descricaoCurta;
  }

  public void setDescricaoCurta(String descricaoCurta) {
    this.descricaoCurta = descricaoCurta;
  }

  public String getDescricaoDetalhada() {
    return descricaoDetalhada;
  }

  public void setDescricaoDetalhada(String descricaoDetalhada) {
    this.descricaoDetalhada = descricaoDetalhada;
  }

  public Double getValorCusto() {
    return valorCusto;
  }

  public void setValorCusto(Double valorCusto) {
    this.valorCusto = valorCusto;
  }

  public Double getValorVenda() {
    return valorVenda;
  }

  public void setValorVenda(Double valorVenda) {
    this.valorVenda = valorVenda;
  }

  public Marca getMarca() {
    return marca;
  }

  public void setMarca(Marca marca) {
    this.marca = marca;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<ProdutoImagem> getImagens() {
    return imagens;
  }

  public void setImagens(List<ProdutoImagem> imagens) {
    this.imagens = imagens;
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
    ProdutoDTO other = (ProdutoDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
