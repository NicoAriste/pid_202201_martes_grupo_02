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

import com.proyecto.entity.Visita;
import com.proyecto.service.VisitaService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/visita")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class VisistaController {

	@Autowired
	private VisitaService visitaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visita>> listaVisita() {
		List<Visita> lista = visitaService.listaVisita();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVisita(@RequestBody Visita obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFecha_reg_visita(new Date());
			obj.setFecha_llegada_visita(new Date());
			obj.setFecha_salida_visita(new Date());
			
			Visita objSalida = visitaService.insertaActualizaVisita(obj);
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
