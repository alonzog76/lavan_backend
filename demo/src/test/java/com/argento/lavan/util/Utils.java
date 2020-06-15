package com.argento.lavan.util;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.argento.lavan.dto.LavanderiaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

public class Utils {
	
	/**
	 * @param id
	 * @param nome
	 * @param descrizione
	 * @param mockMvc 
	 * @return
	 * @throws Exception
	 */
	public MockHttpServletResponse updateLavanderia(Long id, String nome, String descrizione, MockMvc mockMvc) throws Exception {
		String url = "/lavanderie/" + id;

		LavanderiaDto lavanderiaDto = new LavanderiaDto();
		lavanderiaDto.setNome(nome);
		lavanderiaDto.setDescrizione(descrizione);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String lavanderiaJson = ow.writeValueAsString(lavanderiaDto);

		MvcResult result = mockMvc.perform(
				put(url)
				.content(lavanderiaJson)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		return result.getResponse();
	
	}
	
	public LavanderiaDto createLavanderia(String nome, String descrizione, MockMvc mockMvc) throws Exception {
		String url = "/lavanderie";

		LavanderiaDto lavanderiaDto = new LavanderiaDto();
		lavanderiaDto.setNome(nome);
		lavanderiaDto.setDescrizione(descrizione);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String lavanderiaJson = ow.writeValueAsString(lavanderiaDto);

		MvcResult result = mockMvc.perform(
				post(url)
				.content(lavanderiaJson)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andReturn();
	
		Gson g = new Gson();
		return g.fromJson(result.getResponse().getContentAsString(), LavanderiaDto.class);
	
	}
}
