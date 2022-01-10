package com.waracle.cakemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controller endpoints contracts for various cake manager related operations
 * 
 * @author Abilash
 */
public interface CakeApiContract {

	/**
	 * 
	 * Endpoint to add cakes to existing cake
	 * 
	 * @param request The cake request object
	 * @return A response entity with the created cake related information
	 */
	@Operation(summary = "Add cakes", security = @SecurityRequirement(name = "security_auth"), responses = {
			@ApiResponse(description = "Success", responseCode = "201"),
			@ApiResponse(description = "Not Authenticated", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Authorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)})
	public ResponseEntity<CakeResponse> create(final @RequestBody @Valid CakeRequest request);
	
	/**
	 * 
	 * Endpoint to return a list of existing cakes
	 * 
	 * @return Response entity with a list of cakes
	 */
	@Operation(summary = "Get cakes", security = @SecurityRequirement(name = "security_auth"), responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "Not Authenticated", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Authorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)})
	public ResponseEntity<List<CakeResponse>> get();
	
	/**
	 * 
	 * Endpoint to download a list of cakes
	 * 
	 * @return a Response entity with a byte stream to download cakes as JSON data
	 */
	@Operation(summary = "Download cakes", security = @SecurityRequirement(name = "security_auth"), responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "Not found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Not Authenticated", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Authorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)})
	public ResponseEntity<byte[]> downloadJsonFile();
	
}
