package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Mascota;
import com.proyecto.service.MascotaService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/mascota")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class MascotaController {

	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listaMascota() {
		List<Mascota> lista = mascotaService.listaMascota();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMascota(@RequestBody Mascota obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Mascota objSalida = mascotaService.insertaActualizaMascota(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	
}
