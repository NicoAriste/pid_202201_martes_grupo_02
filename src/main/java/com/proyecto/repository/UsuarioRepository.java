package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("Select x from Usuario x where x.login = :#{#usu.login} and x.clave = :#{#usu.clave}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
}
