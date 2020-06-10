package com.argento.lavan.dto;

import java.util.ArrayList;
import java.util.List;

import com.argento.lavan.entities.Lavanderia;

public class LavanderiaDto {

	Long lavanderiaId;
	
	String nome;

	String descrizione;
	
	List<ClienteDto> clienti = new ArrayList<>(); 

	List<PrezzoDto> prezzi = new ArrayList<>();

	List<BollaDto> bolle = new ArrayList<>();

	List<TipoCapoCustomDto> tipiCapoCustom = new ArrayList<>();

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

	public Long getLavanderiaId() {
		return lavanderiaId;
	}

	public void setLavanderiaId(Long lavanderiaId) {
		this.lavanderiaId = lavanderiaId;
	}
	
	/**
	 * @param lavanderia
	 * @return
	 */
	public static LavanderiaDto fromModel(Lavanderia lavanderia) {
		
		LavanderiaDto dto = new LavanderiaDto();
		dto.setNome(lavanderia.getNome());
		dto.setDescrizione(lavanderia.getDescrizione());
		
		return dto;
		
	}
	

}
