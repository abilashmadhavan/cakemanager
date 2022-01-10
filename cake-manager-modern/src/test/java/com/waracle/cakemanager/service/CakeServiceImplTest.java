package com.waracle.cakemanager.service;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.waracle.cakemanager.domain.model.Cake;
import com.waracle.cakemanager.mapper.CakeMapper;
import com.waracle.cakemanager.repository.CakeRepository;
import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 
 * Test class for CakeServiceImpl class
 * 
 * @author Abilash
 *
 */
@ExtendWith(MockitoExtension.class)
public class CakeServiceImplTest {

	/** The cake repository **/
	@Mock
	private CakeRepository cakeRepository;

	/** The cake mapper **/
	@Mock
	private CakeMapper mapper;

	/** The cake service **/
	@InjectMocks
	private CakeServiceImpl cakeService;

	/** The test data **/
	private static String TEST_IMAGE = "TEST_IMAGE";
	private static String TEST_DESCRIPTION = "TEST_DESCRIPTION";
	private static String TEST_TITLE = "TEST_TITLE";
	private static Long TEST_ID = Long.valueOf(889);

	/**
	 * Test to show that a cake can be created
	 */
	@Test
	public void shouldSuccessfullyCreateACake() {
		when(cakeRepository.save(isA(Cake.class))).thenReturn(aCake());
		when(mapper.mapCakeRequestToCake(isA(CakeRequest.class))).thenReturn(aCake());
		when(mapper.mapCakeToCakeResponse(isA(Cake.class))).thenReturn(CakeResponse.builder().id(TEST_ID)
				.description(TEST_DESCRIPTION).image(TEST_IMAGE).title(TEST_TITLE).build());
		CakeResponse response = cakeService.create(CakeRequest.builder().build());

		assertNotNull(response, "response should not be null");
		verify(cakeRepository, times(1)).save(isA(Cake.class));
		verify(mapper, times(1)).mapCakeRequestToCake(isA(CakeRequest.class));
		verify(mapper, times(1)).mapCakeToCakeResponse(isA(Cake.class));
		verifyNoMoreInteractions(cakeRepository, mapper);
	}

	/**
	 * Test to show that a list of cakes can be successfully retrieved
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void shouldSuccessfullygetAListOfCakes() {
		List<Cake> cakeList = new ArrayList<>();
		cakeList.add(this.aCake());
		when(mapper.mapListOfCakeToListCakeResponse(isA(List.class))).thenReturn(cakeList);
		List<CakeResponse> response = cakeService.get();
		assertNotNull(response, "response should not be null");
		verify(mapper, times(1)).mapListOfCakeToListCakeResponse(isA(List.class));
		verifyNoMoreInteractions(mapper);
	}

	/**
	 * Test to show that a list of cakes can be successfully retrieved in byte array
	 * format
	 */
	@Test
	public void shouldSuccessfullygetJsonDataForCakes() {
		List<Cake> cakeList = new ArrayList<>();
		cakeList.add(this.aCake());
		when(cakeRepository.findAll()).thenReturn(cakeList);

		Optional<byte[]> jsonData = cakeService.getCakesJson();
		assertTrue(jsonData.isPresent());
		assertNotNull(jsonData.get(), "response should not be null");
		verify(cakeRepository, times(1)).findAll();
		verifyNoMoreInteractions(mapper);
	}

	/**
	 * Test to show that an optional empty object will be returned when cakes are
	 * not found
	 */
	@Test
	public void shouldReturnEmptyOptionalGetWhenCakesNotFound() {
		List<Cake> cakeList = new ArrayList<>();
		when(cakeRepository.findAll()).thenReturn(cakeList);

		Optional<byte[]> jsonData = cakeService.getCakesJson();
		assertFalse(jsonData.isPresent());
		verify(cakeRepository, times(1)).findAll();
		verifyNoMoreInteractions(mapper);
	}

	/**
	 * 
	 * Returns a cake entity
	 * 
	 * @return a Cake entity
	 */
	private Cake aCake() {
		return Cake.builder().id(TEST_ID).description(TEST_DESCRIPTION).image(TEST_IMAGE).title(TEST_TITLE).build();
	}

}
