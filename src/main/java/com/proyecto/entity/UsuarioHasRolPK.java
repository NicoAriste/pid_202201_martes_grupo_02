package com.proyecto.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class UsuarioHasRolPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cod_usuario;
	private int idRol;

}
