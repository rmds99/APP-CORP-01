package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.Pergunta;
import com.imposto_de_renda.repository.PerguntaRepository;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class PerguntaService 
{
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	
	public List<Pergunta> findAll()
	{
		return this.perguntaRepository.findAll();
	}
	
	public Pergunta findById(Long id)
	{
		Optional<Pergunta> pergunta = this.perguntaRepository.findById(id);
		
		return pergunta.orElseThrow(() -> new ObjectNotFoundException("Pergunta não encontrada"));
	}
}
