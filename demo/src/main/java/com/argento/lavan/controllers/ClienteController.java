package com.argento.lavan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.argento.lavan.dto.ClienteDto;
import com.argento.lavan.dto.LavanderiaDto;
import com.argento.lavan.entities.Cliente;
import com.argento.lavan.entities.Lavanderia;
import com.argento.lavan.service.ClienteService;
import com.argento.lavan.service.LavanderiaService;

@RestController
public class ClienteController {

	@Autowired
	LavanderiaService lavanderiaService;
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping(value = "/lavanderia/{idLavanderia}/clienti", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LavanderiaDto> createCliente(
			@PathVariable(name = "idLavanderia") Long lavanderiaId, @RequestBody ClienteDto clienteDto){
	
		Lavanderia lavanderia = lavanderiaService.retrieveOneLavanderia(lavanderiaId);
		
		Cliente cliente = clienteDto.toModel();
		lavanderia.addCliente(cliente);
		
		Lavanderia updatedLavanderia = lavanderiaService.persist(lavanderia);
		
		return new ResponseEntity<>(updatedLavanderia.toDto(), HttpStatus.OK);
	}
	
	@GetMapping(value = "{idCliente}/lavanderia/{idLavanderia}", produces = "application/json")
	public ResponseEntity<ClienteDto> findCliente(Long idCliente, Long idLavanderia){
		
		Cliente cliente = clienteService.findOne(idCliente, idLavanderia);
		
		return new ResponseEntity<>(cliente.toDto(), HttpStatus.OK);
	}
	
	
	
}
