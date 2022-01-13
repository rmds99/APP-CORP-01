package com.imposto_de_renda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.Acoes;

@Repository
public interface AcoesRepository extends JpaRepository<Acoes, Long>
{
	List<Acoes> findByUsuarioId(Long id);
}
