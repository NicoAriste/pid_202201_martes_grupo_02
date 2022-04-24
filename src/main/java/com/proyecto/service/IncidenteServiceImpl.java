package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Incidente;
import com.proyecto.repository.IncidenteRepository;


public class IncidenteServiceImpl implements IncidenteService{

	@Autowired
	private IncidenteRepository repository;

	@Override
	public Incidente insertaIncidente(Incidente obj) {
		return repository.save(obj);
	}

}
