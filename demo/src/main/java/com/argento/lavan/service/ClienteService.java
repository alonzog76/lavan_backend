package com.argento.lavan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argento.lavan.entities.Cliente;
import com.argento.lavan.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente findOne(Long idCliente, Long idLavanderia) {
		return clienteRepository.findByIdAndLavanderia(idCliente, idLavanderia).get();
	}
	
	

}
