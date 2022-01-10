package com.waracle.cakemanager.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.waracle.cakemanager.domain.model.Cake;

/**
 * 
 * The tess class for CakeRepository
 * 
 * @author Abilash
 *
 */
@SpringBootTest
public class CakeRepositoryTest {
	
	/**The test values **/
	private static String TEST_IMAGE = "TEST_IMAGE";
	private static String TEST_DESCRIPTION = "TEST_DESCRIPTION";
	private static String TEST_TITLE = "TEST_TITLE";
	
	/**The cake repository **/
	@Autowired
	CakeRepository cakeRepository;
	
	/**The clear down method**/
	@AfterEach
	public void clearData() {
		cakeRepository.deleteAll();
	}
	
	/**
	 * Test to show that cake can be successfully saved
	 */
	@Test
	public void shouldSuccessfullySaveCake() {
		Cake cake = this.getCakes(1).get(0);
		Cake savedCake = cakeRepository.save(cake);
		
		assertNotNull(savedCake,"saved cake should be not null");
		assertNotNull(savedCake.getId(),"id should be not null");
		assertEquals(cake.getImage(), savedCake.getImage(), "image should match");
		assertEquals(cake.getDescription(), savedCake.getDescription(), "description should match");
		assertEquals(cake.getTitle(), savedCake.getTitle(), "title should match");
	}
	
	/**
	 * Test to show that cakes can be successfully retrieved
	 */
	@Test
	public void shouldSuccessfullyFindAllCakes() {
		List<Cake> cakeList = this.getCakes(2) ;
		cakeList.stream().forEach(cakeRepository::save);
		List<Cake> savedCakes = cakeRepository.findAll();
		
		assertNotNull(savedCakes,"saved cakes should be not null");
		assertEquals(2, savedCakes.size(), "saved cakes size should match");
		assertTrue(cakeList.stream().anyMatch(cake -> cake.getDescription().equals(TEST_DESCRIPTION+0)));
		assertTrue(cakeList.stream().anyMatch(cake -> cake.getDescription().equals(TEST_DESCRIPTION+1)));
		assertTrue(cakeList.stream().anyMatch(cake -> cake.getImage().equals(TEST_IMAGE+0)));
		assertTrue(cakeList.stream().anyMatch(cake -> cake.getImage().equals(TEST_IMAGE+1)));
		assertTrue(cakeList.stream().anyMatch(cake -> cake.getTitle().equals(TEST_TITLE+0)));
		assertTrue(cakeList.stream().anyMatch(cake -> cake.getTitle().equals(TEST_TITLE+1)));
	}
	
	/**
	 * 
	 * Returns a list of cakes matching to the number passed in
	 * 
	 * @param number an integer number
	 * @return a List of cakes
	 */
	private List<Cake> getCakes(int number) {
		List<Cake> cakeList = new ArrayList<>();
		for(int i=0;i<number;i++ ) {
			cakeList.add(Cake.builder().description(TEST_DESCRIPTION + i).image(TEST_IMAGE + i).title(TEST_TITLE + i).build());
		}
		return cakeList;
	}
	
	

}
