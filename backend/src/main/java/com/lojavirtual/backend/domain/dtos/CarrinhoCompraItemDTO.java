package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lojavirtual.backend.domain.models.CarrinhoCompra;
import com.lojavirtual.backend.domain.models.CarrinhoCompraItem;
import com.lojavirtual.backend.domain.models.Produto;

public class CarrinhoCompraItemDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer quantidade;
  private CarrinhoCompra carrinhoCompra;
  private Produto produto;

  public CarrinhoCompraItemDTO() {
  }

  public CarrinhoCompraItemDTO(Integer id, Integer quantidade, CarrinhoCompra carrinhoCompra,
      Produto produto) {
    this.id = id;
    this.quantidade = quantidade;
    this.carrinhoCompra = carrinhoCompra;
    this.produto = produto;
  }

  public CarrinhoCompraItemDTO(CarrinhoCompraItem obj) {
    this.id = obj.getId();
    this.quantidade = obj.getQuantidade();
    this.carrinhoCompra = obj.getCarrinhoCompra();
    this.produto = obj.getProduto();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public CarrinhoCompra getCarrinhoCompra() {
    return carrinhoCompra;
  }

  public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
    this.carrinhoCompra = carrinhoCompra;
  }

  @JsonIgnore
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
    CarrinhoCompraItemDTO other = (CarrinhoCompraItemDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
