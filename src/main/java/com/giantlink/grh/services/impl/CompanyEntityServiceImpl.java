package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;
import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.CompanyEntityMapper;
import com.giantlink.grh.repositories.CompanyEntityRepository;
import com.giantlink.grh.services.CompanyEntityService;

@Service
public class CompanyEntityServiceImpl implements CompanyEntityService {
	
	@Autowired
	private CompanyEntityRepository companyEntityRepository;
	
	@Override
	public CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException {
		
		CompanyEntity companyEntity =  CompanyEntityMapper.INSTANCE.CompanyEntityRequestToCompanyEntity(companyEntityRequest);
		if (companyEntityRepository.findByName(companyEntity.getName()).isPresent())
			throw new AlreadyExistsException(CompanyEntity.class.getSimpleName(), companyEntityRequest.getName() + " Already Exists !");	
		
		return  CompanyEntityMapper.INSTANCE.CompanyEntityToCompanyEntityResponse(companyEntityRepository.save(companyEntity));
	}
	
	@Override
	public List<CompanyEntityResponse> get() {
		return CompanyEntityMapper.INSTANCE.mapReponse(companyEntityRepository.findAll());
	}

	@Override
	public CompanyEntityResponse get(Integer id) throws ResourceNotFoundException {
		
		Optional<CompanyEntity> compEntity = companyEntityRepository.findById(id);
		if(!compEntity.isPresent())
		    throw new ResourceNotFoundException("CompanyEntity not found with id :" + id);
		
		return  CompanyEntityMapper.INSTANCE.CompanyEntityToCompanyEntityResponse(compEntity.get());	
	}
	
	@Override
	public CompanyEntityResponse get(String name) throws ResourceNotFoundException {
		
		Optional<CompanyEntity> compEntity = companyEntityRepository.findByName(name);
		if(!compEntity.isPresent())
		    throw new ResourceNotFoundException("CompanyEntity not found with name :" + name);
		
		return  CompanyEntityMapper.INSTANCE.CompanyEntityToCompanyEntityResponse(compEntity.get());	
	}

	@Override
    public void delete(Integer id) throws ResourceNotFoundException {
		
		CompanyEntity companyEntity = companyEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CompanyEntity not found"));
		
		companyEntity.getCompany().getEntities().remove(companyEntity);
    	companyEntityRepository.delete(companyEntity);
    }

}
