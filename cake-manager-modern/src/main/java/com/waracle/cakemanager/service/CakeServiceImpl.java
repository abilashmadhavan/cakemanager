package com.waracle.cakemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waracle.cakemanager.domain.model.Cake;
import com.waracle.cakemanager.mapper.CakeMapper;
import com.waracle.cakemanager.repository.CakeRepository;
import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;

import lombok.extern.slf4j.Slf4j;

import com.google.gson.Gson;

/**
 * 
 * Service layer that is invoked by the controller to save and fetch cake
 * related data
 * 
 * @author Abilash
 *
 */
@Service
@Slf4j
public class CakeServiceImpl implements CakeService {

	/** The cake repository **/
	@Autowired
	CakeRepository cakeRepository;

	/** The cake mapper **/
	@Autowired
	CakeMapper cakeMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = false)
	public CakeResponse create(final CakeRequest request) {
		log.debug("cake is being created in service layer" + request);
		return this.cakeMapper
				.mapCakeToCakeResponse(cakeRepository.save(this.cakeMapper.mapCakeRequestToCake(request)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CakeResponse> get() {
		log.debug("cakes are being being retrieved in service layer");
		return this.cakeMapper.mapListOfCakeToListCakeResponse(cakeRepository.findAll());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<byte[]> getCakesJson() {
		log.debug("cakes byte array for json download is being retrieved in service layer");
		List<Cake> cakeList = cakeRepository.findAll();
		if (cakeList != null && !cakeList.isEmpty()) {
			Gson gson = new Gson();
			return Optional.of(gson.toJson(cakeList).getBytes());
		}
		return Optional.empty();
	}

}
