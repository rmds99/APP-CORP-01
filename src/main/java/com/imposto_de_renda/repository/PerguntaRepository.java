package com.imposto_de_renda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>
{

}
