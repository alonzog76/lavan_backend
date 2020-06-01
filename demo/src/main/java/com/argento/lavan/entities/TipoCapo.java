package com.argento.lavan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TipoCapo {

	@Id @GeneratedValue
	Long id;
	
	@OneToMany
	Prezzo prezzo;
	
	String name;
	
	String description;
	
}
