package com.argento.lavan.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.argento.lavan.dto.LavanderiaDto;
import com.argento.lavan.entities.Lavanderia;

@RestController(value = "/lavanderie")
public class LavanderiaController {
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Lavanderia>> getLavanderie(){
		return null;
	}
	
	@GetMapping(value="{id}", produces = "application/json")
	public ResponseEntity<Lavanderia> getLavanderia(
			@PathVariable String id){
		
		return null;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> createLavanderia(
			@PathVariable String fleetId,
            @RequestBody LavanderiaDto lavanderiaDto){
		return null;
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<Void> updateLavanderia(){
		return null;
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteLavanderia(){
		return null;
	}
	
}
