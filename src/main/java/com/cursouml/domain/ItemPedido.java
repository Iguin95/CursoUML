package com.cursouml.domain;

import java.io.Serializable;
import java.util.Objects;

import com.cursouml.domain.pk.ItemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK(); //id de tipo composto
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Pedido getPedido() {//Permite que o pedido e o produto sejam acessados fora da classe ItemPedido...
		return id.getPedido();//o que melhora a semantica do código ao inves de pegar o id da classe ItemPedido...
	}//e depois retornar os pedidos e/ou os produtos
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
}
