package com.argento.lavan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argento.lavan.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findByIdAndLavanderia(Long idCliente, Long idLavanderia);

}
