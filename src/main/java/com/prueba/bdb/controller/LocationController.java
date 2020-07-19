package com.prueba.bdb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bdb.dto.LocationChildDTO;
import com.prueba.bdb.dto.LocationParentDTO;
import com.prueba.bdb.services.LocationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@PostMapping("/parent")
	public ResponseEntity<?> create(@RequestBody LocationParentDTO dto) {
		LocationParentDTO location = null;
		Map<String, Object> response = new HashMap<>();
		try {
			location = service.saveParents(dto);
		}catch (Exception e) {
			response.put("mensaje", "Error al crear la locacion en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La locacion ha sido creada");
		response.put("locacion", location);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/parent")
	public ResponseEntity<?> consult() {
		List<LocationParentDTO> location = null;
		Map<String, Object> response = new HashMap<>();
		try {
			location = service.consultParent();
		}catch (Exception e) {
			response.put("mensaje", "Error al consultar en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la consulta fue exitosa");
		response.put("locacion", location);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/child")
	public ResponseEntity<?> create(@RequestBody LocationChildDTO dto) {
		LocationChildDTO location = null;
		Map<String, Object> response = new HashMap<>();
		try {
			location = service.save(dto);
		}catch (Exception e) {
			response.put("mensaje", "Error al crear la locacion en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La locacion ha sido creada");
		response.put("locacion", location);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/child/{parent}")
	public ResponseEntity<?> consult(@PathVariable Integer parent) {
		List<LocationChildDTO> location = null;
		Map<String, Object> response = new HashMap<>();
		try {
			location = service.consultChild(parent);
		}catch (Exception e) {
			response.put("mensaje", "Error al consultar en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la consulta fue exitosa");
		response.put("locacion", location);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/child")
	public ResponseEntity<?> delete(@PathVariable Integer child) {
		Map<String, Object> response = new HashMap<>();
		try {
			service.deleteChild(child);
		}catch (Exception e) {
			response.put("mensaje", "Error al consultar en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la consulta fue exitosa");
		response.put("locacion", child);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

}
