package com.imposto_de_renda.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imposto_de_renda.entidades.Usuario;
import com.imposto_de_renda.entidades.dto.UsuarioDto;
import com.imposto_de_renda.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController
{
	@Autowired 
	private UsuarioService usuarioService;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll()
	{
		List<Usuario> listaUsuarios = this.usuarioService.findAll();
		
		List<UsuarioDto> listaUsuariosDto = listaUsuarios.stream().map(x-> mapper.map(x,UsuarioDto.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaUsuariosDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(mapper.map(this.usuarioService.findById(id), UsuarioDto.class));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto)
	{
		Usuario usuario = this.usuarioService.create(usuarioDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> update(@PathVariable(name = "id") Long id, @RequestBody UsuarioDto usuarioDto)
	{
		usuarioDto.setId(id);
		
		Usuario usuario = this.usuarioService.update(usuarioDto);
		
		return ResponseEntity.ok().body(mapper.map(usuario, UsuarioDto.class));
		
	}

}
