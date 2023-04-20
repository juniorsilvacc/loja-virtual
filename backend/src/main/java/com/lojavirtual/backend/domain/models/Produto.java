package com.lojavirtual.backend.domain.models;

import java.io.Serializable;

import com.lojavirtual.backend.domain.dtos.ProdutoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String descricaoCurta;
  private String descricaoDetalhada;
  private Double valorCusto;
  private Double valorVenda;

  public Produto() {
  }

  public Produto(Integer id, String descricaoCurta, String descricaoDetalhada, Double valorCusto, Double valorVenda) {
    this.id = id;
    this.descricaoCurta = descricaoCurta;
    this.descricaoDetalhada = descricaoDetalhada;
    this.valorCusto = valorCusto;
    this.valorVenda = valorVenda;
  }

  public Produto(ProdutoDTO obj) {
    this.id = obj.getId();
    this.descricaoCurta = obj.getDescricaoCurta();
    this.descricaoDetalhada = obj.getDescricaoDetalhada();
    this.valorCusto = obj.getValorCusto();
    this.valorVenda = obj.getValorVenda();
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
    Produto other = (Produto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
