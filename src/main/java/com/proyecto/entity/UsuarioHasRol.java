package com.proyecto.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario_has_rol")
public class UsuarioHasRol {

	@EmbeddedId
	private UsuarioHasRolPK usuarioHasRolPk;

	@ManyToOne
	@JoinColumn(name = "cod_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol;

}
