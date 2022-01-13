package com.imposto_de_renda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imposto_de_renda.entidades.Cidade;
import com.imposto_de_renda.service.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController 
{
	@Autowired
	private CidadeService cidadeService;
	
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll()
	{
		return ResponseEntity.ok().body(this.cidadeService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(this.cidadeService.findById(id));
	}
	
	@GetMapping(value = "/estado")
	public ResponseEntity<List<Cidade>> findByEstado(@RequestParam Long id)
	{
		return ResponseEntity.ok().body(this.cidadeService.findByEstadoIdEstado(id));
	}

}
