package com.imposto_de_renda.entidades;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calculo_desconto")
public class CalculoDesconto 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "salario_bruto", nullable = false)
	private BigDecimal salarioBruto;
	
	@Column(name = "taxa")
	private BigDecimal taxa;
	
	
	@Column(name = "salario_liquido")
	private BigDecimal salarioLiquido;
	
	@OneToOne
	@JoinColumn(name = "id_usuario",unique = true)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public BigDecimal getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(BigDecimal salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		CalculoDesconto other = (CalculoDesconto) obj;
		return Objects.equals(id, other.id);
	}
	
}
