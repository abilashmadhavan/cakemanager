package com.waracle.cakemanager.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.waracle.cakemanager.domain.model.Cake;
import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;

/**
 * 
 * The mapper class for various cake manager related mapping functions
 * 
 * @author Abilash
 *
 */
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class CakeMapper {

	/** 
	 * This method maps a cake request to cake entity
	 * 
	 * @param request a cake request object
	 * @return A cake entity
	 */
	public abstract Cake mapCakeRequestToCake(CakeRequest request);
	
	/**
	 * This method maps a cake entity to a cake response
	 * 
	 * @param cake A cake entity
	 * @return A cake response
	 */
	public abstract CakeResponse mapCakeToCakeResponse(Cake cake);
	
	/**
	 * This method converts a list of cake to a list o cake response
	 * 
	 * @param cake A list of Cake entity
	 * @return a  List of cake response
	 */
	public abstract List<CakeResponse> mapListOfCakeToListCakeResponse(List<Cake> cake);
	
}
