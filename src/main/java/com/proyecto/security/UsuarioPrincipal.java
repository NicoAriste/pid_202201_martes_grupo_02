package com.proyecto.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.proyecto.entity.Rol;
import com.proyecto.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;

@Getter
@Setter
@AllArgsConstructor
@CommonsLog
@ToString
public class UsuarioPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int cod_usuario;
	private String login;
	private String password;
	private String nombreUsuario;
	private static String nombreCompleto;
	private Collection<? extends GrantedAuthority> authorities;

	public static UsuarioPrincipal build(Usuario usuario, List<Rol> roles) {
		log.info(">>>UsuarioPrincipal >> " + usuario);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Rol x : roles) {
			authorities.add(new SimpleGrantedAuthority(x.getNombre()));
		}
		nombreCompleto = usuario.getNom_usuario();
		return new UsuarioPrincipal(usuario.getCod_usuario(), usuario.getLogin(), usuario.getClave(),
				usuario.getNom_usuario(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

}
