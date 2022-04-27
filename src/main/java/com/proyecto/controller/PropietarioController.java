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

import com.proyecto.entity.Propietario;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class PropietarioController {
	
	@Autowired
	private PropietarioService propietarioService;
	
	@GetMapping("/listaPropietario")
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietario() {
		List<Propietario> lista = propietarioService.listaPropietario();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPropietario(@RequestBody Propietario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFecha_incio_contrato(new Date());
			obj.setFecha_fin_contrato(new Date());
			Propietario objSalida = propietarioService.insertaActualizaPropietario(obj);
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
