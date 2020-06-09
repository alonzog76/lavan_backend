package com.argento.lavan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argento.lavan.dto.LavanderiaDto;
import com.argento.lavan.entities.Lavanderia;
import com.argento.lavan.repository.LavanderiaRepository;

@Service
public class LavanderiaService {

	Logger log = LoggerFactory.getLogger(LavanderiaService.class); 
			
	@Autowired
	LavanderiaRepository lavanderiaRepository;

	/** Create a new lavanderia
	 * 
	 * @param dto
	 * @return
	 */
	public LavanderiaDto createLavanderia(final LavanderiaDto dto) {

		log.info("Creating new lavanderia with name {}" + dto.getNome());

		Lavanderia lavanderia = new Lavanderia();
		lavanderia.setNome(dto.getNome());
		lavanderia.setDescrizione(dto.getDescrizione());

		Lavanderia newLavanderia = lavanderiaRepository.save(lavanderia);

		log.info("Created new lavanderia with id {}" + newLavanderia.getId());

		dto.setLavanderiaId(newLavanderia.getId());
		
		return dto;

	}

	/**
	 * @param id
	 * @param dto
	 * @return
	 */
	public Lavanderia updateLavanderia(final Long id, final LavanderiaDto dto){
		
		log.info("Updating lavanderia with id {}" + id);
		
		Lavanderia lavanderia = retrieveOneLavanderia(id);

		if(lavanderia != null){
			lavanderia.setNome(dto.getNome());
			lavanderia.setDescrizione(dto.getDescrizione());
		}else{
			log.error("Lavanderia with id {} not found" + id);
		}

		return lavanderia;
	}
	
	/** all lavanderie
	 * 
	 * @return
	 */
	public List<Lavanderia> retrieveAllLavanderia(){
		return lavanderiaRepository.findAll();

	}
	
	public Lavanderia retrieveOneLavanderia(Long id){
		return lavanderiaRepository.findById(id).orElse(null);
	}

}
