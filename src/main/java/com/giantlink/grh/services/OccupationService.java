package com.giantlink.grh.services;

import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

import java.util.List;


public interface OccupationService {

	OccupationResponse add(OccupationRequest OccupationRequest) throws AlreadyExistsException;
	OccupationResponse get(Integer id) throws ResourceNotFoundException;
	OccupationResponse get(String name) throws ResourceNotFoundException;
	List<OccupationResponse> get();
    void delete(Integer id) throws ResourceNotFoundException;
}
