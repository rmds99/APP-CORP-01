package com.imposto_de_renda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>
{
	List<Cidade> findByEstadoId(Long id);
}
