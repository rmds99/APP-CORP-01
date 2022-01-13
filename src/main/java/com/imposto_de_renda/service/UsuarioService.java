package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.Usuario;
import com.imposto_de_renda.entidades.dto.UsuarioDto;
import com.imposto_de_renda.repository.UsuarioRepository;
import com.imposto_de_renda.service.exceptions.DataIntegratyViolationException;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<Usuario> findAll()
	{
		return this.usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) 
	{
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public Usuario create(UsuarioDto usuarioDto)
	{		
		validacao(usuarioDto);
		
		usuarioDto.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
		return this.usuarioRepository.save(mapper.map(usuarioDto, Usuario.class));
	}
	
	public Usuario update(UsuarioDto usuarioDto)
	{
		validacao(usuarioDto);
		
		return this.usuarioRepository.save(mapper.map(usuarioDto, Usuario.class));
	}
	
	public void validacao(UsuarioDto usuarioDto)
	{
		Optional<Usuario> usuario = this.usuarioRepository.findByEmail(usuarioDto.getEmail());
		
		if(usuario.isPresent() && !usuario.get().getId().equals(usuarioDto.getId()))
		{
			throw new DataIntegratyViolationException("Esse email ja foi cadastrado por outro utilizador");
		}
	}
}
