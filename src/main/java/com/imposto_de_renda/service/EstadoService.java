package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.Estado;
import com.imposto_de_renda.repository.EstadoRepository;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService 
{
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public List<Estado> findAll()
	{
		return this.estadoRepository.findAll();
	}
	
	public Estado findById(Long id)
	{
		Optional<Estado> estado = this.estadoRepository.findById(id);
		
		return estado.orElseThrow( () -> new ObjectNotFoundException("Estado não encontrado"));
	}

}
