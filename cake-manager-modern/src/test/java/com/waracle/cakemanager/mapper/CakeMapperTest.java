package com.waracle.cakemanager.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.waracle.cakemanager.domain.model.Cake;
import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;

/**
 * 
 * Test for CakeMapper class
 * 
 * @author Abilash 
 *
 */
public class CakeMapperTest {
	
	/** The mapper object **/
	private CakeMapper mapper = Mappers.getMapper(CakeMapper.class);
	
	/** The test values **/
	private static String TEST_IMAGE = "TEST_IMAGE";
	private static String TEST_DESCRIPTION = "TEST_DESCRIPTION";
	private static String  TEST_TITLE = "TEST_TITLE";
	private static Long  TEST_ID = Long.valueOf(889);
	
	/**
	 * Test to show that cake request can be mapped to cake entity
	 */
	@Test
	public void shouldSuccessfullyMapCakeRequestToCake() {
		Cake cake = mapper.mapCakeRequestToCake(CakeRequest.builder().description(TEST_DESCRIPTION).image(TEST_IMAGE).title(TEST_TITLE).build());
		
		assertEquals(TEST_IMAGE, cake.getImage(),  "cake image should match");
		assertEquals(TEST_DESCRIPTION, cake.getDescription(), "description should match");
		assertEquals(TEST_TITLE, cake.getTitle(), "title should match");
	}
	
	/**
	 * Test to show that cake can be mapped to cake response
	 */
	@Test
	public void shouldSuccessfullyMapCakeToCakeResponse() {
		CakeResponse response = mapper.mapCakeToCakeResponse(this.aCake());
		
		assertEquals(TEST_ID, response.getId(),  "id should match");
		assertEquals(TEST_IMAGE, response.getImage(),  "cake image should match");
		assertEquals(TEST_DESCRIPTION, response.getDescription(), "description should match");
		assertEquals(TEST_TITLE, response.getTitle(), "title should match");
	}
	
	/**
	 * Test to show that a list of cake can be mapped to list of cake response
	 */
	@Test
	public void shouldSuccessfullyMapListOfCakeToListCakeResponse() {
		List<Cake> cakeList = new ArrayList<>();
		cakeList.add(this.aCake());
		List<CakeResponse> response = mapper.mapListOfCakeToListCakeResponse(cakeList);
		assertEquals(TEST_ID, response.get(0).getId(),  "id should match");
		assertEquals(TEST_IMAGE, response.get(0).getImage(),  "cake image should match");
		assertEquals(TEST_DESCRIPTION, response.get(0).getDescription(), "description should match");
		assertEquals(TEST_TITLE, response.get(0).getTitle(), "title should match");
	}
	
	/**
	 * Returns a Cake entity
	 * 
	 * @return a Cake entity
	 */
	private Cake aCake() {
		return Cake.builder().id(TEST_ID).description(TEST_DESCRIPTION).image(TEST_IMAGE).title(TEST_TITLE).build();
	}
	
	
}
 