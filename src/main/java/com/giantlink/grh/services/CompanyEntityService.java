package com.giantlink.grh.services;

import java.util.List;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

public interface CompanyEntityService {
	CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException;
	CompanyEntityResponse get(Integer id) throws ResourceNotFoundException;
	CompanyEntityResponse get(String name) throws ResourceNotFoundException;
	List<CompanyEntityResponse> get();
    void delete(Integer id) throws ResourceNotFoundException;

}
