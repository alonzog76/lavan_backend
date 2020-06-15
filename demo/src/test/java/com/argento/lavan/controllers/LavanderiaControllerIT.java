package com.argento.lavan.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.argento.lavan.dto.LavanderiaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class LavanderiaControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetLavanderie() throws Exception {

		createLavanderia("lav1", "descr1");
		createLavanderia("lav2", "descr2");
		createLavanderia("lav3", "descr3");
		
		String url = "/lavanderie";
		
		MvcResult result = mockMvc.perform(
				get(url))
				.andExpect(status().isOk())
				.andReturn();
		
		Gson g = new Gson();
		List<LavanderiaDto> lavanderie = 
				g.fromJson(result.getResponse().getContentAsString(), List.class);
		
		
		assertEquals(3, lavanderie.size());
		
	}

	@Test
	public void testGetLavanderia() throws Exception {
		
		MockHttpServletResponse response = createLavanderia("lav1", "descr1");
		Gson g = new Gson();
		LavanderiaDto lavDto = g.fromJson(response.getContentAsString(), LavanderiaDto.class);
		
		String url = "/lavanderie/" + lavDto.getLavanderiaId();
		
		MvcResult result = mockMvc.perform(
				get(url))
				.andExpect(status().isOk())
				.andReturn();

		result.getResponse();
		LavanderiaDto lavanderiaResponseDto = g.fromJson(response.getContentAsString(), LavanderiaDto.class);
		
		assertEquals("lav1", lavanderiaResponseDto.getNome());
		assertEquals("descr1", lavanderiaResponseDto.getDescrizione());
		
	}

	@Test
	public void testCreateLavanderia() throws Exception {

		MockHttpServletResponse response = createLavanderia("lav1", "descr1");

		Gson g = new Gson();
		LavanderiaDto lavanderiaResponseDto = g.fromJson(response.getContentAsString(), LavanderiaDto.class);

		assertEquals("lav1", lavanderiaResponseDto.getNome());
		assertEquals("descr1", lavanderiaResponseDto.getDescrizione());
	}

	@Test
	public void testUpdateLavanderia() throws Exception {

		MockHttpServletResponse response = createLavanderia("lav1", "descr1");
		Gson g = new Gson();
		LavanderiaDto lavDto = g.fromJson(response.getContentAsString(), LavanderiaDto.class);


		response = updateLavanderia(lavDto.getLavanderiaId(), "new name", "new descr");
		lavDto = g.fromJson(response.getContentAsString(), LavanderiaDto.class);

		assertEquals("new name", lavDto.getNome());
		assertEquals("new descr", lavDto.getDescrizione());
	}

	@Test
	public void testDeleteLavanderia() {
	}

	/**
	 * @param nome
	 * @param descrizione
	 * @return
	 * @throws Exception
	 */
	private MockHttpServletResponse createLavanderia(String nome, String descrizione) throws Exception {
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

		return result.getResponse();
	}

	/**
	 * @param id
	 * @param nome
	 * @param descrizione
	 * @return
	 * @throws Exception
	 */
	private MockHttpServletResponse updateLavanderia(Long id, String nome, String descrizione) throws Exception {
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
}
