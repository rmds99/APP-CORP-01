package com.imposto_de_renda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imposto_de_renda.entidades.Sexo;
import com.imposto_de_renda.service.SexoService;


@RestController
@RequestMapping(value = "/sexo")
public class SexoController 
{
	@Autowired
	private SexoService sexoService;
	
	@GetMapping
	public ResponseEntity<List<Sexo>> findAll()
	{
		return ResponseEntity.ok().body(this.sexoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sexo> findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(this.sexoService.findById(id));
	}
}