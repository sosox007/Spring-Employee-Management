package com.giantlink.grh.services;

import java.util.List;
//import java.util.Optional;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

public interface CompanyService {
	
	CompanyResponse add(CompanyRequest companyRequest) throws AlreadyExistsException;
	CompanyResponse get(Integer id) throws ResourceNotFoundException;
	CompanyResponse get(String name) throws ResourceNotFoundException;
	List<CompanyResponse> get();
	void delete(Integer id) throws ResourceNotFoundException;
	
}
