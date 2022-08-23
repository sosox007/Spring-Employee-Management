package com.giantlink.grh.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.DepartementMapper;
import com.giantlink.grh.repositories.DepartementRepository;
import com.giantlink.grh.services.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	private DepartementRepository departementRepository;

	@Override
	public DepartementResponse add(DepartementRequest departementRequest) throws AlreadyExistsException {

		Departement departement = DepartementMapper.INSTANCE.DepartementRequestToDepartement(departementRequest);
		if (departementRepository.findByName(departement.getName()).isPresent())
			throw new AlreadyExistsException(Departement.class.getSimpleName(),
					departementRequest.getName() + " Already Exists !");

		return DepartementMapper.INSTANCE.DepartementToDepartementResponse(departementRepository.save(departement));
	}

	@Override
	public List<DepartementResponse> get() {
		return DepartementMapper.INSTANCE.mapReponse(departementRepository.findAll());
	}

	@Override
	public DepartementResponse get(Integer id) throws ResourceNotFoundException {

		Optional<Departement> departement = departementRepository.findById(id);
		if (!departement.isPresent())
			throw new ResourceNotFoundException("Departement not found with id :" + id);

		return DepartementMapper.INSTANCE.DepartementToDepartementResponse(departement.get());
	}

	@Override
	public DepartementResponse get(String name) throws ResourceNotFoundException {
		Optional<Departement> departement = departementRepository.findByName(name);
		if (!departement.isPresent())
			throw new ResourceNotFoundException("Departement not found with name :" + name);

		return DepartementMapper.INSTANCE.DepartementToDepartementResponse(departement.get());
	}

	@Override
	public void delete(Integer id) throws ResourceNotFoundException {

		Departement departement = departementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Departement not found"));

		departementRepository.delete(departement);
	}

}
