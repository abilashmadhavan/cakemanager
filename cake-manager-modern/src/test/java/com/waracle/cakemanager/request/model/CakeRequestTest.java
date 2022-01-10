package com.waracle.cakemanager.request.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 
 * Test class for CreateRequest
 * 
 * @author Abilash
 *
 */
public class CakeRequestTest {

	/** The validator**/
	private Validator validator;
	
	/** The cake request**/
	private CakeRequest cakeRequest;
	
	/**The test values **/
	private static String TEST_IMAGE = "TEST_IMAGE";
	private static String TEST_DESCRIPTION = "TEST_DESCRIPTION";
	private static String TEST_TITLE = "TEST_TITLE";
	
	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator(); 
		this.cakeRequest = CakeRequest.builder().description(TEST_DESCRIPTION).image(TEST_IMAGE).title(TEST_TITLE).build();
	}
	
	/**
	 * Test a valid request
	 */
	@Test
	public void testValidRequestModel() {
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Test request when title is null
	 */
	@Test
	public void testTitleNull() {
		cakeRequest.setTitle(null);
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertEquals("Enter a title",violations.iterator().next().getMessage());
	}
	
	/**
	 * Test title when its more than 100 char
	 */
	@Test
	public void testTitleMoreThan100Char() {
		cakeRequest.setTitle(StringUtils.repeat("a", 101));
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertEquals("Title must be 100 char or less",violations.iterator().next().getMessage());
	}
	
	/**
	 * Test request when description is null
	 */
	@Test
	public void testDescriptionNull() {
		cakeRequest.setDescription(null);
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertEquals("Enter a description",violations.iterator().next().getMessage());
	}

	/**
	 * Test description when its more than 100 char
	 */
	@Test
	public void testDescriptionMoreThan100Char() {
		cakeRequest.setDescription(StringUtils.repeat("a", 101));
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertEquals("Description name must be 100 char or less",violations.iterator().next().getMessage());
	}
	
	/**
	 * Test request when image is null
	 */
	@Test
	public void testImageNull() {
		cakeRequest.setImage(null);
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertEquals("Enter an image",violations.iterator().next().getMessage());
	}

	/**
	 * Test image when its more than 100 char
	 */
	@Test
	public void testImageMoreThan300Char() {
		cakeRequest.setImage(StringUtils.repeat("a", 301));
		final Set<ConstraintViolation<CakeRequest>>  violations = validator.validate(cakeRequest);
		assertEquals("Image must be 300 char or less",violations.iterator().next().getMessage());
	}
	
	
}
