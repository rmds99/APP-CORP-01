package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.Acoes;
import com.imposto_de_renda.entidades.dto.AcoesDto;
import com.imposto_de_renda.repository.AcoesRepository;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class AcoesService 
{
	@Autowired
	private AcoesRepository acoesRepository;
	
	@Autowired
	private ModelMapper mapper;
		
	
	public List<Acoes> findAll()
	{
		return this.acoesRepository.findAll();
	}
	
	public List<Acoes> findByUsuario(Long id)
	{
		return this.acoesRepository.findByUsuarioId(id);
	}

	
	public Acoes findById(Long id)
	{
		Optional<Acoes> acoes = this.acoesRepository.findById(id);
		
		return acoes.orElseThrow( () -> new ObjectNotFoundException("Ação não encontrada"));
	}
	
	public Acoes create (AcoesDto acoesDto)
	{
		return this.acoesRepository.save(mapper.map(acoesDto, Acoes.class));
	}
	
	public void delete(Long id)
	{
		findById(id);
		
		this.acoesRepository.deleteById(id);
	}
	
	public Acoes update (AcoesDto acoesDto)
	{
		return this.acoesRepository.save(mapper.map(acoesDto, Acoes.class));
	}	
	
}
