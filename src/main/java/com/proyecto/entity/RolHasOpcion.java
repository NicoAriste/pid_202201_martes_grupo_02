package com.proyecto.entity;


import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyecto.entity.RolHasOpcionPK;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tb_rol_has_opcion")
public class RolHasOpcion {

	@EmbeddedId
	private RolHasOpcionPK rolHasOpcionPK;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOpcion", nullable = false, insertable = false, updatable = false)
	private Opcion opcion;

}
