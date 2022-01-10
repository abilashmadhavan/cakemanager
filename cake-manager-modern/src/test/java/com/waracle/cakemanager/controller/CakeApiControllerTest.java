package com.waracle.cakemanager.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;
import com.waracle.cakemanager.service.CakeService;

/**
 * 
 * Test class for CakeApiController
 * 
 * @author Abilash
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(CakeApiController.class)
@ActiveProfiles("test")
public class CakeApiControllerTest {

	/** The cake service **/
	@MockBean
	private CakeService cakeService;

	/** The mock mvc **/
	@Autowired
	private MockMvc mockMvc;

	/** The object mapper **/
	@Autowired
	private ObjectMapper objectMapper;

	/** The test data **/
	private static String TEST_IMAGE = "TEST_IMAGE";
	private static String TEST_DESCRIPTION = "TEST_DESCRIPTION";
	private static String TEST_TITLE = "TEST_TITLE";

	/**
	 * 
	 * Test the successful creation of a cake
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void shouldSuccessfullyReturn201WhenCakeIsCreated() throws JsonProcessingException, Exception {
		CakeRequest cakeRequest = CakeRequest.builder().description(TEST_DESCRIPTION).image(TEST_IMAGE)
				.title(TEST_TITLE).build();
		when(cakeService.create(isA(CakeRequest.class))).thenReturn(CakeResponse.builder().build());
		this.mockMvc
				.perform(
						post("/cakes").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(cakeRequest)))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().string(containsString(asJsonString(CakeResponse.builder().build()))));
	}

	/**
	 * 
	 * Test the successful retrieval of cake list
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void shouldSuccessfullyReturn200WhenCakeListIsRetrieved() throws JsonProcessingException, Exception {

		List<CakeResponse> cakeList = new ArrayList<>();
		cakeList.add(CakeResponse.builder().build());
		when(cakeService.get()).thenReturn(cakeList);
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(asJsonString(cakeList))));
	}

	/**
	 * 
	 * Test the successful retrieval of cake list as byte array
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void shouldSuccessfullyReturn200WhenCakeListIsRetrievedAsByteArray()
			throws JsonProcessingException, Exception {

		List<CakeResponse> cakeList = new ArrayList<>();
		cakeList.add(CakeResponse.builder().build());

		byte[] cakes = new byte[] {};
		when(cakeService.getCakesJson()).thenReturn(Optional.of(cakes));
		this.mockMvc.perform(get("/cakes")).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * 
	 * Test that 404 should be thrown when cakes are not found during download
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void shouldSuccessfullyReturn404WhenCakeListIsRetrievedAsByteArrayAndIsNotFound()
			throws JsonProcessingException, Exception {

		when(cakeService.getCakesJson()).thenReturn(Optional.empty());
		this.mockMvc.perform(get("/cakes")).andDo(print()).andExpect(status().isNotFound());
	}

	/**
	 * 
	 * @param obj The object to be converted to json
	 * @return a json string representation object the object passed
	 * @throws JsonProcessingException
	 */
	private String asJsonString(Object obj) throws JsonProcessingException {
		return objectMapper.writeValueAsString(obj);
	}

}
