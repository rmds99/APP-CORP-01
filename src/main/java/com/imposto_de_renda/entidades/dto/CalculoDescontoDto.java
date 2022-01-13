package com.imposto_de_renda.entidades.dto;

public class CalculoDescontoDto 
{
	private Long id;
	private Double salarioBruto; 
	private Long usuarioId;
	
	public CalculoDescontoDto()
	{
		
	}
	
	public CalculoDescontoDto(Double salarioBruto, Long usuarioId) 
	{
		super();
		this.salarioBruto = salarioBruto;
		this.usuarioId = usuarioId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	

}
