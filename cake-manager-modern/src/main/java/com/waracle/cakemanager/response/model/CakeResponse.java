package com.waracle.cakemanager.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * The cake response class
 * 
 * @author Abilash
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CakeResponse {

	/** The id **/
	private Long id;

	/** The title **/
	private String title;

	/** The description **/
	private String description;

	/** The image **/
	private String image;

}
