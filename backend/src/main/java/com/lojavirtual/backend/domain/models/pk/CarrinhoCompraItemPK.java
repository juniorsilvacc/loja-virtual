package com.lojavirtual.backend.domain.models.pk;

import java.io.Serializable;

import com.lojavirtual.backend.domain.models.CarrinhoCompra;
import com.lojavirtual.backend.domain.models.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CarrinhoCompraItemPK implements Serializable {

	private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "carrinho_compra_id")
  private CarrinhoCompra carrinhoCompra;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

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
    result = prime * result + ((carrinhoCompra == null) ? 0 : carrinhoCompra.hashCode());
    result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
    CarrinhoCompraItemPK other = (CarrinhoCompraItemPK) obj;
    if (carrinhoCompra == null) {
      if (other.carrinhoCompra != null)
        return false;
    } else if (!carrinhoCompra.equals(other.carrinhoCompra))
      return false;
    if (produto == null) {
      if (other.produto != null)
        return false;
    } else if (!produto.equals(other.produto))
      return false;
    return true;
  }

}
