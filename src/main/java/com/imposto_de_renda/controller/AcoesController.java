package com.imposto_de_renda.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imposto_de_renda.entidades.Acoes;
import com.imposto_de_renda.entidades.dto.AcoesDto;
import com.imposto_de_renda.service.AcoesService;

@RestController
@RequestMapping(value = "/acoes")
public class AcoesController 
{
	@Autowired
	private AcoesService acoesService;
	
	@Autowired 
	private ModelMapper mapper;
	
	
	@GetMapping
	public ResponseEntity<List<Acoes>> findAll()
	{
		return ResponseEntity.ok().body(this.acoesService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AcoesDto> findById(@PathVariable(value = "id") Long id)
	{
		return ResponseEntity.ok().body(mapper.map(this.acoesService.findById(id), AcoesDto.class));
	}
	
	@GetMapping(value = "/usuario/{id}")
	public ResponseEntity<List<Acoes>> findByUsuario(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(this.acoesService.findByUsuario(id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AcoesDto> delete(@PathVariable(name = "id") Long id)
	{
		this.acoesService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AcoesDto> update(@PathVariable Long id, @RequestBody AcoesDto acoesDto)
	{
		acoesDto.setId(id);
		
		Acoes acoes = this.acoesService.update(acoesDto);
		
		return ResponseEntity.ok().body(mapper.map(acoes, AcoesDto.class)); 
	}
	
	@PostMapping
	public ResponseEntity<AcoesDto> create(@RequestBody AcoesDto acoesDto)
	{
		Acoes acoes = this.acoesService.create(acoesDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acoes.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
