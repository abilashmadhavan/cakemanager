package com.waracle.cakemanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;
import com.waracle.cakemanager.service.CakeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller endpoints for various cake manager related operations
 * 
 * @author Abilash
 */
@RestController
@RequestMapping(value = "/")
@CrossOrigin
@SecurityRequirement(name = "security_auth")
@Slf4j
public class CakeApiController implements CakeApiContract {

	/** The Cake service **/
	@Autowired
	private CakeService cakeService;

	/**
	 * {@inheritDoc}
	 */
	@PostMapping(path = { "cakes" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CakeResponse> create(final @RequestBody @Valid CakeRequest request) {
		log.info("cake is being created " + request);
		return new ResponseEntity<>(this.cakeService.create(request), HttpStatus.CREATED);
	}

	/**
	 * {@inheritDoc}
	 */
	@GetMapping
	public ResponseEntity<List<CakeResponse>> get() {
		log.info("cakes are being being retrieved");
		return new ResponseEntity<>(this.cakeService.get(), HttpStatus.OK);
	}

	/**
	 * {@inheritDoc}
	 */
	@GetMapping("cakes")
	public ResponseEntity<byte[]> downloadJsonFile() {
		log.info("cakes byte array for json download is being retrieved");
		Optional<byte[]> cakes = this.cakeService.getCakesJson();
		if (cakes.isPresent()) {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=cakes.json")
					.contentType(MediaType.APPLICATION_JSON).contentLength(cakes.get().length).body(cakes.get());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
