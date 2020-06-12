package com.argento.lavan.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TipoCapoCustom {

	@Id @GeneratedValue
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Lavanderia lavanderia;
	
	@OneToMany
	List<Prezzo> prezzi;
	
	String name;
	
	String description;
	
}
