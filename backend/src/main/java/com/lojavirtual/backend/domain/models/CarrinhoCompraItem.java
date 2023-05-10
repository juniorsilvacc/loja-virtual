package com.lojavirtual.backend.domain.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lojavirtual.backend.domain.models.pk.CarrinhoCompraItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carrinho_compra_item") 
public class CarrinhoCompraItem implements Serializable{

  private static final long serialVersionUID = 1L;

  @EmbeddedId
	private CarrinhoCompraItemPK id = new CarrinhoCompraItemPK();

  private Integer quantidade;
  private Double valor; 

  public CarrinhoCompraItem() {
  } 

  public CarrinhoCompraItem(CarrinhoCompra carrinhoCompra, Produto produto, Integer quantidade, Double valor) {
    id.setCarrinhoCompra(carrinhoCompra);
    id.setProduto(produto);
    this.quantidade = quantidade;
    this.valor = valor;
  }

  public Double getSubTotal() {
    return valor * quantidade;
  }

  @JsonIgnore
  public CarrinhoCompra getCarrinhoCompra() {
    return id.getCarrinhoCompra();
  }

  public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
    id.setCarrinhoCompra(carrinhoCompra);
  }

  public Produto getProduto() {
    return id.getProduto();
  }

  public void setProduto(Produto produto) {
    id.setProduto(produto);
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
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
    CarrinhoCompraItem other = (CarrinhoCompraItem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
