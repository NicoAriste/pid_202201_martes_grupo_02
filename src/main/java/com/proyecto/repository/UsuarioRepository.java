package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Opcion;
import com.proyecto.entity.Rol;
import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("Select x from Usuario x where x.login = :#{#usu.login} and x.clave = :#{#usu.clave}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where  p.idOpcion = pr.opcion.idOpcion and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.cod_usuario = :var_cod")
	public abstract List<Opcion> traerEnlacesDeUsuario(@Param("var_cod") int idUsuario);

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.cod_usuario = :var_cod")
	public abstract List<Rol> traerRolesDeUsuario(@Param("var_cod")int idUsuario);

	public abstract Usuario findByLogin(String login);
}
