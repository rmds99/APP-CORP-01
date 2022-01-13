package com.imposto_de_renda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.CalculoDesconto;

@Repository
public interface CalculoDescontoRepository extends JpaRepository<CalculoDesconto, Long>
{
	Optional<CalculoDesconto> findByUsuarioId(Long id);
}
