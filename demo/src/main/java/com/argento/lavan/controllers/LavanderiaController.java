package com.argento.lavan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.argento.lavan.service.LavanderiaService;




@RestController(value = "/lavanderie")
public class LavanderiaController {
	
	@Autowired
	LavanderiaService lavanderiaService;
	
	
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
	public ResponseEntity<LavanderiaDto> createLavanderia(
			@RequestBody LavanderiaDto lavanderiaDto){
		
		Lavanderia lavanderia = lavanderiaService.createLavanderia(lavanderiaDto);
		
		return new ResponseEntity<>(LavanderiaDto.fromModel(lavanderia), HttpStatus.OK);
	}
	
	@PutMapping(value="{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LavanderiaDto> updateLavanderia(Long id, LavanderiaDto dto){
		
		Lavanderia lavanderia = lavanderiaService.updateLavanderia(id, dto);
		
		return new ResponseEntity<>(LavanderiaDto.fromModel(lavanderia), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteLavanderia(){
		return null;
	}
	
}
