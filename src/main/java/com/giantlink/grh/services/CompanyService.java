 package com.giantlink.grh.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.entities.Company;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

public interface CompanyService {

	CompanyResponse add(CompanyRequest companyRequest) throws AlreadyExistsException;

	CompanyResponse update(Integer id, CompanyRequest companyRequest) throws ResourceNotFoundException;

	CompanyResponse get(Integer id) throws ResourceNotFoundException;

	CompanyResponse get(String name) throws ResourceNotFoundException;

	void delete(Integer id) throws ResourceNotFoundException;

	List<CompanyResponse> get();

	List<CompanyResponse> get(int page, int size, Sort sortedBy);

	//List<CompanyResponse> get(Pageable pageable);

	//Page<CompanyResponse> get(Pageable pageable);

}
