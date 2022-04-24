package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Mascota;
import com.proyecto.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	private MascotaRepository Repository;
	
	@Override
	public List<Mascota> listaMascota() {
		return Repository.findAll();
	}

	@Override
	public Mascota insertaActualizaMascota(Mascota obj) {
		return Repository.save(obj);
	}

}
