package com.argento.lavan.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

			// Perform call
			/*MvcResult result = mockMvc.perform(post(url)
			 .header("x-user-id", operator.getId()))
			 .andExpect(status().isForbidden())
			 .andReturn();
			*/
	@Test
	public void testGetLavanderie() {
	
	}

	@Test
	public void testGetLavanderia() {
	
	}

	@Test
	public void testCreateLavanderia() throws Exception {
		
		String url = "/lavanderie";
		
		LavanderiaDto lavanderiaDto = new LavanderiaDto();
		lavanderiaDto.setNome("la mia lavanderia");
		lavanderiaDto.setDescrizione("la prima lavanderia");
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String lavanderiaJson = ow.writeValueAsString(lavanderiaDto);
		
		MvcResult result = mockMvc.perform(
		 post(url)
		 .content(lavanderiaJson)
		 .contentType(MediaType.APPLICATION_JSON))
		 .andExpect(status().isCreated())
		 .andReturn();
		
		
		MockHttpServletResponse response = result.getResponse();
		
		Gson g = new Gson();
		LavanderiaDto lavanderiaResponseDto = g.fromJson(response.getContentAsString(), LavanderiaDto.class);

		
		assertEquals("la mia lavanderia", lavanderiaResponseDto.getNome());
		assertEquals("la prima lavanderia", lavanderiaResponseDto.getDescrizione());
	}

	@Test
	public void testUpdateLavanderia() {
	}

	@Test
	public void testDeleteLavanderia() {
	}

	private void createLavanderia() {
		
	}
}
