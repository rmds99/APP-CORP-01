package com.imposto_de_renda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imposto_de_renda.entidades.Pergunta;
import com.imposto_de_renda.service.PerguntaService;

@RestController
@RequestMapping(value = "/pergunta")
public class PerguntaController 
{
	@Autowired
	private PerguntaService perguntaService;
	
	
	@GetMapping
	public ResponseEntity<List<Pergunta>> findAll()
	{
		return ResponseEntity.ok().body(this.perguntaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pergunta> findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(this.perguntaService.findById(id));
	}
}
