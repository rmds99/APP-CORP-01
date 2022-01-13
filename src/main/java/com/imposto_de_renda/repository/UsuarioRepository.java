package com.imposto_de_renda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imposto_de_renda.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{

	Optional<Usuario> findByEmail(String email);

}
