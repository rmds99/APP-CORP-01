package com.imposto_de_renda.entidades.dto;

import java.util.Date;

public class AcoesDto 
{
	private Long id;
	private String nomeAcao;
	private Double valor;
	private Date dataInvestimento;
	private Date dataResgate;
	private Long usuarioId;
	
	public AcoesDto()
	{
		
	}

	
	public AcoesDto(String nomeAcao, Double valor, Date dataInvestimento, Date dataResgate, Long usuarioId) 
	{
		super();
		this.nomeAcao = nomeAcao;
		this.valor = valor;
		this.dataInvestimento = dataInvestimento;
		this.dataResgate = dataResgate;
		this.usuarioId = usuarioId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeAcao() {
		return nomeAcao;
	}
	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
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
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
