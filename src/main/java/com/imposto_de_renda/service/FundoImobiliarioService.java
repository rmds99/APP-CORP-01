package com.imposto_de_renda.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.FundoImobiliario;
import com.imposto_de_renda.entidades.dto.FundoImobiliarioDto;
import com.imposto_de_renda.repository.FundoImobiliarioRepository;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@Service
public class FundoImobiliarioService 
{
	@Autowired
	private FundoImobiliarioRepository FundoImobiliarioRepository;
	
	@Autowired
	private ModelMapper mapper;
		
	
	public List<FundoImobiliario> findAll()
	{
		return this.FundoImobiliarioRepository.findAll();
	}
	
	public List<FundoImobiliario> findByUsuario(Long id)
	{
		return this.FundoImobiliarioRepository.findByUsuarioId(id);
	}

	
	public FundoImobiliario findById(Long id)
	{
		Optional<FundoImobiliario> FundoImobiliario = this.FundoImobiliarioRepository.findById(id);
		
		return FundoImobiliario.orElseThrow( () -> new ObjectNotFoundException("Fundo não encontrado"));
	}
	
	public FundoImobiliario create (FundoImobiliarioDto fundoImobiliarioDto)
	{
		return this.FundoImobiliarioRepository.save(mapper.map(fundoImobiliarioDto, FundoImobiliario.class));
	}
	
	public void delete(Long id)
	{
		findById(id);
		
		this.FundoImobiliarioRepository.deleteById(id);
	}
	
	public FundoImobiliario update (FundoImobiliarioDto FundoImobiliarioDto)
	{
		return this.FundoImobiliarioRepository.save(mapper.map(FundoImobiliarioDto, FundoImobiliario.class));
	}	
	

}
