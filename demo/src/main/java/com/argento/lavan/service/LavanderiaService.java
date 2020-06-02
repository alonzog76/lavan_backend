package com.argento.lavan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argento.lavan.dto.LavanderiaDto;
import com.argento.lavan.entities.Lavanderia;
import com.argento.lavan.repository.LavanderiaRepository;

@Service
public class LavanderiaService {
	
	@Autowired
	LavanderiaRepository lavanderiaRepository;
	
	/** Create a new lavanderia
	 * 
	 * @param dto
	 * @return
	 */
	public Lavanderia createLavanderia(LavanderiaDto dto) {
		
		Lavanderia lavanderia = new Lavanderia();
		lavanderia.setNome(dto.getNome());
		lavanderia.setDescrizione(dto.getDescrizione());
		
		return lavanderiaRepository.save(lavanderia);
		
	}

}
