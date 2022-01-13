package com.imposto_de_renda.entidades.dto;

public class UsuarioDto 
{	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Long sexoId;
	private Long cidadeId;
	
	public UsuarioDto(){}
	
	public UsuarioDto(Long id, String nome, String email, String senha, Long sexoId, Long cidadeId) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexoId = sexoId;
		this.cidadeId = cidadeId;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getSexoId() {
		return sexoId;
	}
	public void setSexoId(Long sexoId) {
		this.sexoId = sexoId;
	}
	public Long getCidadeId() {
		return cidadeId;
	}
	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
}
