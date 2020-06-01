package com.argento.lavan.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argento.lavan.entities.Lavanderia;

@RestController(value = "/lavanderie")
public class LavanderiaController {
	
	@GetMapping
	public ResponseEntity<List<Lavanderia>> getLavanderie(){
		return null;
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Lavanderia> getLavanderia(){
		return null;
	}

	@PostMapping(consumes="")
	public ResponseEntity<Void> createLavanderia(){
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
