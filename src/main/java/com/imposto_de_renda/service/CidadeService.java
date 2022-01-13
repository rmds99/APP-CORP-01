package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.Cidade;
import com.imposto_de_renda.repository.CidadeRepository;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService 
{
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public List<Cidade> findAll()
	{
		return this.cidadeRepository.findAll();
	}
	
	public List<Cidade> findByEstadoIdEstado(Long estado)
	{
		return this.cidadeRepository.findByEstadoId(estado);
	}
	
	public Cidade findById(Long id)
	{
		Optional<Cidade> cidade = this.cidadeRepository.findById(id);
		
		return cidade.orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada"));
	}

}
