package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.entities.Company;
import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.CompanyEntityMapper;
import com.giantlink.grh.mapper.CompanyMapper;
import com.giantlink.grh.repositories.CompanyEntityRepository;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.services.CompanyEntityService;

@Service
public class CompanyEntityServiceImpl implements CompanyEntityService {

	@Autowired
	private CompanyEntityRepository companyEntityRepository;

	@Autowired
	private CompanyRepository companyRepository;

	
	@Override
	public CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException {
		System.out.println(companyEntityRequest);
		CompanyEntity companyEntity = CompanyEntityMapper.INSTANCE
				.CompanyEntityRequestToCompanyEntity(companyEntityRequest);
		if (companyEntityRepository.findByName(companyEntity.getName()).isPresent())
			throw new AlreadyExistsException(CompanyEntity.class.getSimpleName(),
					companyEntityRequest.getName() + " Already Exists !");
		
		companyEntity.setCompany(companyRepository.findById(companyEntityRequest.getCompany_id()).get());
		return CompanyEntityMapper.INSTANCE
				.CompanyEntityToCompanyEntityResponse(companyEntityRepository.save(companyEntity));
	}
	
	@Override
	public CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntityRequest) throws ResourceNotFoundException {

		Optional<CompanyEntity> compEntity = companyEntityRepository.findById(id);
		if (!compEntity.isPresent())
			throw new ResourceNotFoundException("CompanyEntity not found with id :" + id);

		compEntity.get().setName(companyEntityRequest.getName());
		compEntity.get().setCompany(companyRepository.findById(companyEntityRequest.getCompany_id()).get());
		return CompanyEntityMapper.INSTANCE.CompanyEntityToCompanyEntityResponse(companyEntityRepository.save(compEntity.get()));
	}

	@Override
	public List<CompanyEntityResponse> get() {
		return CompanyEntityMapper.INSTANCE.mapReponse(companyEntityRepository.findAll());
	}

	@Override
	public CompanyEntityResponse get(Integer id) throws ResourceNotFoundException {

		Optional<CompanyEntity> compEntity = companyEntityRepository.findById(id);
		if (!compEntity.isPresent())
			throw new ResourceNotFoundException("CompanyEntity not found with id :" + id);

		return CompanyEntityMapper.INSTANCE.CompanyEntityToCompanyEntityResponse(compEntity.get());
	}

	@Override
	public CompanyEntityResponse get(String name) throws ResourceNotFoundException {

		Optional<CompanyEntity> compEntity = companyEntityRepository.findByName(name);
		if (!compEntity.isPresent())
			throw new ResourceNotFoundException("CompanyEntity not found with name :" + name);

		return CompanyEntityMapper.INSTANCE.CompanyEntityToCompanyEntityResponse(compEntity.get());
	}

	@Override
	public void delete(Integer id) throws ResourceNotFoundException {

		CompanyEntity companyEntity = companyEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CompanyEntity not found"));

		companyEntityRepository.delete(companyEntity);
	}

}
