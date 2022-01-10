package com.waracle.cakemanager.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * The entity layer representing a Cake
 * 
 * @author Abilash
 *
 */
@Entity
@Table(name = "cake")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cake {

	/** The id **/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cake_sequence")
	@SequenceGenerator(name="cake_sequence", sequenceName ="cake_sequence", allocationSize = 1 )
	private Long id;

	/** The title **/
	@Column(name = "title", unique = true, nullable = false, length = 100)
	private String title;

	/** The description **/
	@Column(name = "description", unique = false, nullable = false, length = 100)
	private String description;

	/** The image **/
	@Column(name = "image", unique = false, nullable = false, length = 300)
	private String image;

}
