package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

public interface DepartementService {

	DepartementResponse add(DepartementRequest departementRequest) throws AlreadyExistsException;
	DepartementResponse get(Integer id) throws ResourceNotFoundException;
	DepartementResponse get(String name) throws ResourceNotFoundException;
	List<DepartementResponse> get();
	void delete(Integer id) throws ResourceNotFoundException;
	DepartementResponse update(Integer id, DepartementRequest departementRequest) throws ResourceNotFoundException;
	
}
