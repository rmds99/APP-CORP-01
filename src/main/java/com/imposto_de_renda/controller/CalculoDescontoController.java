package com.imposto_de_renda.controller;

import java.net.URI;

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

import com.imposto_de_renda.entidades.CalculoDesconto;
import com.imposto_de_renda.entidades.dto.CalculoDescontoDto;
import com.imposto_de_renda.service.CalculoDescontoService;

@RestController
@RequestMapping(value = "/calculo")
public class CalculoDescontoController 
{
	@Autowired
	private CalculoDescontoService calculoDescontoService;
	
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CalculoDesconto> findById(@PathVariable(value = "id") Long id)
	{
		return ResponseEntity.ok().body(this.calculoDescontoService.findByUsuarioIdUsuario(id));
	}
	
	@PostMapping
	public ResponseEntity<CalculoDescontoDto> create(@RequestBody CalculoDescontoDto calculoDescontoDto)
	{
		CalculoDesconto calculoDesconto = this.calculoDescontoService.create(calculoDescontoDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(calculoDesconto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CalculoDesconto> update(@PathVariable Long id, @RequestBody CalculoDescontoDto calculoDescontoDto)
	{
		calculoDescontoDto.setId(id);
		
		CalculoDesconto calculoDesconto = this.calculoDescontoService.update(calculoDescontoDto);
		
		return ResponseEntity.ok().body(calculoDesconto); 
	}
}
