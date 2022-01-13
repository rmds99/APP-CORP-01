package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.Sexo;
import com.imposto_de_renda.repository.SexoRepository;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class SexoService 
{
	@Autowired
	private SexoRepository sexoRepository;
	
	
	public List<Sexo> findAll()
	{
		return this.sexoRepository.findAll();
	}
	
	
	public Sexo findById(Long id)
	{
		Optional<Sexo> sexo = this.sexoRepository.findById(id);
		
		return sexo.orElseThrow(() -> new ObjectNotFoundException("Sexo não encontrado"));
	}
}
