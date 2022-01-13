package com.imposto_de_renda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.Sexo;

@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long>
{

}
