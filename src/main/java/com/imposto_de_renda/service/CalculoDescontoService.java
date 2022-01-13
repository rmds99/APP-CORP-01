package com.imposto_de_renda.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imposto_de_renda.entidades.CalculoDesconto;
import com.imposto_de_renda.entidades.dto.CalculoDescontoDto;
import com.imposto_de_renda.repository.CalculoDescontoRepository;
import com.imposto_de_renda.service.exceptions.DataIntegratyViolationException;

@Service
public class CalculoDescontoService 
{
	@Autowired
	private CalculoDescontoRepository calculoDescontoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	public CalculoDesconto findByUsuarioIdUsuario(Long id)
	{
		Optional<CalculoDesconto> calculo = this.calculoDescontoRepository.findByUsuarioId(id);
		
		return calculo.orElse(null);
	}
	
	public CalculoDesconto create(CalculoDescontoDto calculoDescontoDto)
	{
		CalculoDesconto verificar = this.findByUsuarioIdUsuario(calculoDescontoDto.getUsuarioId());
		
		if(verificar == null)
		{
			CalculoDesconto calculoDesconto = mapper.map(calculoDescontoDto, CalculoDesconto.class);
			calculoDesconto.setTaxa(calcularTaxa(calculoDesconto.getSalarioBruto()));			
			calculoDesconto.setSalarioLiquido(calcularSalarioLiquido(calculoDesconto.getSalarioBruto(), calculoDesconto.getTaxa()));
			
			return this.calculoDescontoRepository.save(calculoDesconto);
		}
		else
			throw new DataIntegratyViolationException("Usuário ja realizou o calculo ! Faça uma "
					+ "actualização do salario bruto, caso queira recalcular");
	}
	
	public CalculoDesconto update(CalculoDescontoDto calculoDescontoDto)
	{
		return this.calculoDescontoRepository.save(mapper.map(calculoDescontoDto, CalculoDesconto.class));
	}
	
	public BigDecimal calcularTaxa(BigDecimal salarioBruto)
	{
		if ( salarioBruto.compareTo(conversao(4664.68)) > 0 )
		{
			return conversao(27.50);
		}
		else if ( salarioBruto.compareTo(conversao(3751.06)) >= 0 && salarioBruto.compareTo(conversao(4664.68)) <= 0)
		{
			return conversao(22.50);
		}
		else if ( salarioBruto.compareTo(conversao(2828.66)) >= 0 && salarioBruto.compareTo(conversao(3751.05)) <= 0 )
		{
			return conversao(15.00);
		}
		else if ( salarioBruto.compareTo(conversao(1903.99)) >= 0 && salarioBruto.compareTo(conversao(2826.65)) <= 0)
		{
			return conversao(7.50);
		}
		return conversao(0.00);
	}
	
	public BigDecimal calcularSalarioLiquido(BigDecimal salarioBruto, BigDecimal taxa)
	{
		BigDecimal percentagem = taxa.divide(conversao(100.0), RoundingMode.HALF_EVEN);
		BigDecimal salarioLiquido = salarioBruto.subtract(percentagem .multiply(salarioBruto));
		
		return salarioLiquido;
	}
	
	public BigDecimal conversao(Double numero)
	{
		return new BigDecimal(numero);
	}
}
