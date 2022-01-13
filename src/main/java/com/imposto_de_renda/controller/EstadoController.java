package com.imposto_de_renda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imposto_de_renda.entidades.Estado;
import com.imposto_de_renda.service.EstadoService;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController 
{
	@Autowired
	private EstadoService estadoService;
	
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll()
	{
		return ResponseEntity.ok().body(this.estadoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(this.estadoService.findById(id));
	}

}
