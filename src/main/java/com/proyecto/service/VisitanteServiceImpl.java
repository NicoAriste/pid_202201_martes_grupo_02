package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Visitante;
import com.proyecto.repository.VisitanteRepository;
@Service
public class VisitanteServiceImpl implements VisitanteService{

	@Autowired
	private VisitanteRepository repository;
	
	@Override
	public List<Visitante> listaVisitante() {
		return repository.findAll();
	}

	
}
