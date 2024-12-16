package com.cursouml.domain;

import java.io.Serializable;
import java.util.Objects;

import com.cursouml.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private EstadoPagamento estadoPagamento;
	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId //isso garante que vai ser o mesmo id
	private Pedido pedido;/*como é uma relação de um p/ um, eu quero que o pagamento tenha
	o mesmo id que Pedido, por isso que no atributo do id, ele não recebe a anotação que
	gera um numero de id automaticamente, isso é gerado pela outra classe da associação que 
	recebe nos parametros da sua anotação o valor cascade = CascadeType.ALL*/
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
}
