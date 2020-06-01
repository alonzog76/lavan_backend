package com.argento.lavan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prezzo {

	@Id @GeneratedValue
	Long id;
	
	@ManyToOne
	TipoCapo tipoCapo;
	
	boolean completo;
	
	boolean soloStiro;
	
	boolean lavaggioAsecco;
	
	boolean lavaggioInAcqua;
	
	double value;

	@ManyToOne
	@JoinColumn(name = "lavanderia")
	Lavanderia lavanderia;
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
