package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_administrador")

public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_admin;
	private String nom_admin;
	private String login;
	private String clave;
	private String dni_admin;
	private String telf_admin;
	
}
