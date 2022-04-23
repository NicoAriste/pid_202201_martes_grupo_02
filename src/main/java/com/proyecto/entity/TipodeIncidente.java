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
@Table(name = "tb_tipo_indicente")

public class TipodeIncidente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_tipoinc;
	private String desc_tipoinc;
	private int estado;
	

}
