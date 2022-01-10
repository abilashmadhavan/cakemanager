package com.waracle.cakemanager.service;

import java.util.List;
import java.util.Optional;

import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;

/** The Cake service interface **/
public interface CakeService {

	/** 
	 * This method creates a cake entity in the repository 
	 * 
	 * @param request, The cake request
	 * @return A cake response object
	 * 
	 **/
	public CakeResponse create(final CakeRequest request);

	/** 
	 * This method returns a list of cakes from repository
	 * 
	 *  @return a list of cake response objects
	 * 
	 **/
	public List<CakeResponse> get();

	/**
	 * This method returns a byte array of cakes in json format to be downloaded
	 * 
	 * @return an optional byte array representing cakes
	 **/
	public Optional<byte[]> getCakesJson();

}
