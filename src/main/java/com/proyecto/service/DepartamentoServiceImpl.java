package com.proyecto.service;

import com.proyecto.entity.Departamento;
import com.proyecto.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository repositorio;
	
	@Override
	public Departamento insertaActualizaDepartamento(Departamento obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Departamento> listaDepartament() {
		return repositorio.findAll();
	}
	
	

}
