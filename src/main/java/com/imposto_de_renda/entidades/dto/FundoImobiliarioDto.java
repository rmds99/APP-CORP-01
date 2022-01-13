package com.imposto_de_renda.entidades.dto;

import java.util.Date;

public class FundoImobiliarioDto 
{
	private Long id;
	private String nomeFundo;
	private Double valor;
	private Date dataInvestimento;
	private Date dataResgate;
	private Long usuarioId;
	
	public FundoImobiliarioDto()
	{
		
	}
	
	public FundoImobiliarioDto(String nomeFundo, Double valor, Date dataInvestimento, Date dataResgate,
			Long usuarioId) 
	{
		super();
		this.nomeFundo = nomeFundo;
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
	public String getNomeFundo() {
		return nomeFundo;
	}
	public void setNomeFundo(String nomeFundo) {
		this.nomeFundo = nomeFundo;
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
