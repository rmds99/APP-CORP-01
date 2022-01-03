package com.imposto_de_renda.entidades;

import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "acoes")
public class Acoes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome_acao", nullable = false)
	private String nomeAcao;

	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "data_investimento")
	private Date dataInvestimento;
	
	@Column(name = "data_resgate")
	private Date dataResgate;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeFundo(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(Date dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public Date getDataResgate() {
		return dataResgate;
	}

	public void setDataResgate(Date dataResgate) {
		this.dataResgate = dataResgate;
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
		Acoes other = (Acoes) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}