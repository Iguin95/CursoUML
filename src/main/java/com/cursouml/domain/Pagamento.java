package com.cursouml.domain;

import java.io.Serializable;
import java.util.Objects;

import com.cursouml.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //Anotação para definir a super classe e criar as tabelas no DB...
public abstract class Pagamento implements Serializable{ //o tipo JOINED faz com que cada classe, super e subs, tenha sua propria tabela no DB(melhor configuração para quando há muitos atributos nas subclasses)...
	//já a SINGLE_TABLE faz ter apenas uma tabela, e dependendo da herança que escolher, os atributos da que não foi escolhida recebe todos null no DB(melhor configuração para quando há poucos atributos nas subclasses)
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer estadoPagamento;
	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId 
	private Pedido pedido;
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
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
