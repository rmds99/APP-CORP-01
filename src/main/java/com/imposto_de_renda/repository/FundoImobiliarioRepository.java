package com.imposto_de_renda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.FundoImobiliario;

@Repository
public interface FundoImobiliarioRepository extends JpaRepository<FundoImobiliario, Long>
{
	List<FundoImobiliario> findByUsuarioId(Long id);

}
