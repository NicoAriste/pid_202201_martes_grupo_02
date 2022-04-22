package com.proyecto.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Usuario;

//@Service
public interface UsuarioService {

	public abstract Usuario login(Usuario bean);

	public Page<Usuario> findAll(Pageable pageable);

	public Usuario findById(int id);

	public Usuario save(Usuario bean);

	public void delete(int id);

}
