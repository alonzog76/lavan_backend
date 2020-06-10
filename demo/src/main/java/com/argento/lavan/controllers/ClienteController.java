package com.argento.lavan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.argento.lavan.dto.ClienteDto;
import com.argento.lavan.dto.LavanderiaDto;
import com.argento.lavan.entities.Lavanderia;
import com.argento.lavan.service.LavanderiaService;

@RestController(value = "/clienti")
public class ClienteController {

	@Autowired
	LavanderiaService lavanderiaService;
	
	@PostMapping(value = "/{idLavanderia}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LavanderiaDto> createCliente(
			@PathVariable(name = "idLavanderia") Long lavanderiaId, @RequestBody ClienteDto clienteDto){
	
		Lavanderia lavanderia = lavanderiaService.retrieveOneLavanderia(lavanderiaId);
		
		
		
		return null;
	}
	
	
	
	
}
