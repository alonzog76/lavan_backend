package com.argento.lavan.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lavanderia {

	@Id @GeneratedValue
	Long id;

	@OneToMany(mappedBy = "lavanderia", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Cliente> clienti = new ArrayList<>(); 

	@OneToMany(mappedBy = "lavanderia", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Prezzo> prezzi = new ArrayList<>();

	@OneToMany(mappedBy = "lavanderia", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Bolla> bolle = new ArrayList<>();

	@OneToMany(mappedBy = "lavanderia", cascade = CascadeType.ALL, orphanRemoval = true)
	List<TipoCapoCustom> tipiCapoCustom = new ArrayList<>();

	String nome;

	String descrizione;

	public void addCliente(Cliente cliente) {
		clienti.add(cliente);
		cliente.setLavanderia(this);
	}

	public void removeCliente(Cliente cliente) {
		clienti.remove(cliente);
		cliente.setLavanderia(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}

	public List<Prezzo> getPrezzi() {
		return prezzi;
	}

	public void setPrezzi(List<Prezzo> prezzi) {
		this.prezzi = prezzi;
	}

	public List<Bolla> getBolle() {
		return bolle;
	}

	public void setBolle(List<Bolla> bolle) {
		this.bolle = bolle;
	}

	public List<TipoCapoCustom> getTipiCapoCustom() {
		return tipiCapoCustom;
	}

	public void setTipiCapoCustom(List<TipoCapoCustom> tipiCapoCustom) {
		this.tipiCapoCustom = tipiCapoCustom;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
