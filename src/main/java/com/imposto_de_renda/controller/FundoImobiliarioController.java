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

import com.imposto_de_renda.entidades.FundoImobiliario;
import com.imposto_de_renda.entidades.dto.FundoImobiliarioDto;
import com.imposto_de_renda.service.FundoImobiliarioService;

@RestController
@RequestMapping(value = "/fundo")
public class FundoImobiliarioController 
{
	@Autowired
	private FundoImobiliarioService fundoImobiliarioService;
	
	@Autowired 
	private ModelMapper mapper;
	
	
	@GetMapping
	public ResponseEntity<List<FundoImobiliario>> findAll()
	{
		return ResponseEntity.ok().body(this.fundoImobiliarioService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FundoImobiliarioDto> findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(mapper.map(this.fundoImobiliarioService.findById(id), FundoImobiliarioDto.class));
	}
	
	@GetMapping(value = "/usuario/{id}")
	public ResponseEntity<List<FundoImobiliario>> findByUsuario(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(this.fundoImobiliarioService.findByUsuario(id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FundoImobiliarioDto> delete(@PathVariable(name = "id") Long id)
	{
		this.fundoImobiliarioService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FundoImobiliarioDto> update(@PathVariable Long id, @RequestBody FundoImobiliarioDto fundoImobiliarioDto)
	{
		fundoImobiliarioDto.setId(id);
		
		FundoImobiliario fundoImobiliario = this.fundoImobiliarioService.update(fundoImobiliarioDto);
		
		return ResponseEntity.ok().body(mapper.map(fundoImobiliario, FundoImobiliarioDto.class)); 
	}
	
	@PostMapping
	public ResponseEntity<FundoImobiliarioDto> create(@RequestBody FundoImobiliarioDto fundoImobiliarioDto)
	{
		FundoImobiliario fundoImobiliario = this.fundoImobiliarioService.create(fundoImobiliarioDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fundoImobiliario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}


}
