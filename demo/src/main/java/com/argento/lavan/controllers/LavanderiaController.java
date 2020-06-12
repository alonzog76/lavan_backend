package com.argento.lavan.controllers;

import java.util.List;
import java.util.stream.Collectors;

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


@RestController
public class LavanderiaController {
	
	@Autowired
	LavanderiaService lavanderiaService;
	
	
	@GetMapping(value="/lavanderie/", produces = "application/json")
	public ResponseEntity<List<LavanderiaDto>> getLavanderie(){
		List<Lavanderia> lavanderie = lavanderiaService.retrieveAllLavanderia();

		List<LavanderiaDto> lavanderiaDtos = lavanderie.stream().
				map(Lavanderia::toDto).
				collect(Collectors.toList());

		return new ResponseEntity<>(lavanderiaDtos, HttpStatus.OK);
	}
	
	@GetMapping(value="/lavanderie/{id}", produces = "application/json")
	public ResponseEntity<LavanderiaDto> getLavanderia(@PathVariable Long id){
		
		Lavanderia lavanderia = lavanderiaService.retrieveOneLavanderia(id);
		return new ResponseEntity<>(lavanderia.toDto(), HttpStatus.OK);
	}

	/**
	 * @param lavanderiaDto
	 * @return
	 */
	@PostMapping(value = "/lavanderie", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LavanderiaDto> createLavanderia(@RequestBody LavanderiaDto lavanderiaDto){
		
		Lavanderia lavanderia = lavanderiaService.createLavanderia(lavanderiaDto);
		
		return new ResponseEntity<>(lavanderia.toDto(), HttpStatus.CREATED);
	}
	
	/**
	 * @param id
	 * @param dto
	 * @return
	 */
	@PutMapping(value="/lavanderie/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LavanderiaDto> updateLavanderia(Long id, LavanderiaDto dto){
		
		Lavanderia lavanderia = lavanderiaService.updateLavanderia(id, dto);
		
		return new ResponseEntity<>(lavanderia.toDto(), HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteLavanderia(Long id){
		
		lavanderiaService.deleteLavanderia(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
