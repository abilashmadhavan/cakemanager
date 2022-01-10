package com.waracle.cakemanager.request.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
/**
 * 
 * The Cake request class
 * 
 * @author Abilash
 *
 */
public class CakeRequest {

	/** The title **/
	@NotEmpty(message = "Enter a title")
	@Size(min = 1, message = "Title must be 1 char or more")
	@Size(max = 100, message = "Title must be 100 char or less")
	private String title;

	/** The description **/
	@NotEmpty(message = "Enter a description")
	@Size(min = 1, message = "Description must be 1 char or more")
	@Size(max = 100, message = "Description name must be 100 char or less")
	private String description;

	/** The image **/
	@NotEmpty(message = "Enter an image")
	@Size(min = 1, message = "Image must be 1 char or more")
	@Size(max = 300, message = "Image must be 300 char or less")
	private String image;

}
