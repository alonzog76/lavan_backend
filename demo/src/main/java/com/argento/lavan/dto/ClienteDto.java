package com.argento.lavan.dto;

import com.argento.lavan.entities.Cliente;

public class ClienteDto {
	
	String nome;
	String cognome;
	String indirizzo;
	String telefono;
	String cellulare;
	String partitaIva;
	String email;
	Integer sconto;
	
	public Cliente toModel(){
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCognome(cognome);
		cliente.setIndirizzo(indirizzo);
		cliente.setTelefono(telefono);
		cliente.setCellulare(cellulare);
		cliente.setPartitaIva(partitaIva);
		cliente.setEmail(email);
		cliente.setSconto(sconto);
		
		return cliente;
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSconto() {
		return sconto;
	}
	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}

	
	
}
