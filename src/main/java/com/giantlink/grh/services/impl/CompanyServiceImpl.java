package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.giantlink.grh.entities.Company;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.CompanyMapper;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<CompanyResponse> get() {
		return CompanyMapper.INSTANCE.mapReponse(companyRepository.findAll());
	}
	
	@Override
	public List<CompanyResponse> get(int page,int size,Sort sortedBy) {
		if(page>0) page-=1;
		Pageable pageable = PageRequest.of(page,size, sortedBy);
		return CompanyMapper.INSTANCE.entityToPage(companyRepository.findAll(pageable));
	}

	@Override
	public CompanyResponse add(CompanyRequest companyRequest) throws AlreadyExistsException {

		Company company = CompanyMapper.INSTANCE.CompanyRequestToCompany(companyRequest);
		if (companyRepository.findByName(company.getName()).isPresent())
			throw new AlreadyExistsException(Company.class.getSimpleName(),
					companyRequest.getName() + " Already Exists !");

		return CompanyMapper.INSTANCE.CompanyToCompanyResponse(companyRepository.save(company));
	}

	@Override
	public CompanyResponse update(Integer id, CompanyRequest companyRequest) throws ResourceNotFoundException {

		Optional<Company> comp = companyRepository.findById(id);
		if (!comp.isPresent())
			throw new ResourceNotFoundException("Company not found with id :" + id);

		comp.get().setName(companyRequest.getName());
		comp.get().setEmail(companyRequest.getEmail());
		comp.get().setAddress(companyRequest.getAddress());
		return CompanyMapper.INSTANCE.CompanyToCompanyResponse(companyRepository.save(comp.get()));
	}

	@Override
	public CompanyResponse get(Integer id) throws ResourceNotFoundException {

		Optional<Company> comp = companyRepository.findById(id);
		if (!comp.isPresent())
			throw new ResourceNotFoundException("Company not found with id :" + id);

		return CompanyMapper.INSTANCE.CompanyToCompanyResponse(comp.get());
	}

	@Override
	public CompanyResponse get(String name) throws ResourceNotFoundException {
		Optional<Company> comp = companyRepository.findByName(name);
		if (!comp.isPresent())
			throw new ResourceNotFoundException("Company not found with name :" + name);

		return CompanyMapper.INSTANCE.CompanyToCompanyResponse(comp.get());
	}

	@Override
	public void delete(Integer id) throws ResourceNotFoundException {

		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found"));

		companyRepository.delete(company);

	}





}
