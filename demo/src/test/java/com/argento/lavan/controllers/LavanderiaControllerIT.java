package com.argento.lavan.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetLavanderia() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateLavanderia() throws Exception {
		
		String lavanderiaJson = "{"
				+ "\"nome\" : \"la mia lavanderia\", "
				+ "\"descrizione\" : \"la prima lavanderia\""
				+ "}";
		
		String url = "/lavanderie";
		
		MvcResult result = mockMvc.perform(
		 post(url)
		 .content(lavanderiaJson)
		 .contentType(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk())
		 .andReturn();
		
		
		result.getResponse();
	}

	@Test
	public void testUpdateLavanderia() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteLavanderia() {
		fail("Not yet implemented");
	}

}
