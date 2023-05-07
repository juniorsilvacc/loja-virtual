package com.lojavirtual.backend.domain.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carrinho_compra_item")
public class CarrinhoCompraItem implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

  private Integer quantidade;

  @ManyToOne
  @JoinColumn(name = "carrinho_compra_id")
  private CarrinhoCompra carrinhoCompra;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  public CarrinhoCompraItem() {
  }

  public CarrinhoCompraItem(Integer id, Integer quantidade, CarrinhoCompra carrinhoCompra,
      Produto produto) {
    this.id = id;
    this.quantidade = quantidade;
    this.carrinhoCompra = carrinhoCompra;
    this.produto = produto;
  }

  public Double getSubTotal() {
    return produto.getValor() * quantidade;
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

  @JsonIgnore
  public CarrinhoCompra getCarrinhoCompra() {
    return carrinhoCompra;
  }

  public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
    this.carrinhoCompra = carrinhoCompra;
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
    CarrinhoCompraItem other = (CarrinhoCompraItem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
