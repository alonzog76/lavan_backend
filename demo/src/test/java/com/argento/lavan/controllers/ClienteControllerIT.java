package com.argento.lavan.controllers;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.argento.lavan.dto.ClienteDto;
import com.argento.lavan.dto.LavanderiaDto;
import com.argento.lavan.util.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ClienteControllerIT {

	@Autowired
	MockMvc mockMvc;
	
	private Utils utils;// = new Utils();
	
	LavanderiaDto lavanderiaDto;
	
	@BeforeClass
	public void setup() throws Exception{
		//lavanderiaDto = utils.createLavanderia("Nome", "descrizione", mockMvc);
	}
	
	@Test
	public void testCreateCliente() throws Exception {

		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNome("nome");
		clienteDto.setCognome("cognome");
		clienteDto.setIndirizzo("indirizzo");

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String clienteJson = ow.writeValueAsString(clienteDto);

		String url = "/lavanderie/{id}" + lavanderiaDto.getLavanderiaId();
		
		MvcResult result = mockMvc.perform(
				put(url)
				.content(clienteJson)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		assertNotNull(result);

	}

	@Test
	public void testFindCliente() {

	}

	
}
