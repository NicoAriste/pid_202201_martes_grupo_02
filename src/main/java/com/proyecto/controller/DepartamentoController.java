package com.proyecto.controller;

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
import com.proyecto.entity.Departamento;
import com.proyecto.repository.DepartamentoRepository;
import com.proyecto.service.DepartamentoService;

@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = "http://localhost:4200")

public class DepartamentoController {
	
	
	@Autowired
	private DepartamentoService  departamentoService;
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaDepartamento(@RequestBody Departamento obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objSalida = departamentoService.insertaActualizaDepartamento(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>> obtenerListDepartamento(){
		List<Departamento> lista = departamentoService.listaDepartament();
		return ResponseEntity.ok(lista);
	}
	
	

}
