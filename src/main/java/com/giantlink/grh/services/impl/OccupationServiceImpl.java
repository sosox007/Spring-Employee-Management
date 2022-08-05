package com.giantlink.grh.services.impl;

import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;
import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.OccupationMapper;
import com.giantlink.grh.repositories.OccupationRepository;
import com.giantlink.grh.services.OccupationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OccupationServiceImpl implements OccupationService{
	
    @Autowired
    private OccupationRepository occupationRepository;
	
	@Override
	public OccupationResponse add(OccupationRequest occupationRequest) throws AlreadyExistsException {
	
		Occupation occupation =  OccupationMapper.INSTANCE.OccupationRequestToOccupation(occupationRequest);
		if (occupationRepository.findByName(occupation.getName()).isPresent())
			throw new AlreadyExistsException(Occupation.class.getSimpleName(), occupationRequest.getName() + " Already Exists !");	
		
		return  OccupationMapper.INSTANCE.OccupationToOccupationResponse(occupationRepository.save(occupation));
	}

	@Override
	public List<OccupationResponse> get() {
		return OccupationMapper.INSTANCE.mapReponse(occupationRepository.findAll());
	}

	@Override
	public OccupationResponse get(Integer id) throws ResourceNotFoundException {
        Optional<Occupation>  occupation =  occupationRepository.findById(id);
		if(!occupation.isPresent())
		    throw new ResourceNotFoundException("Occupation not found with id :" + id);
		return  OccupationMapper.INSTANCE.OccupationToOccupationResponse(occupation.get());
	}

    @Override
	public OccupationResponse get(String name) throws ResourceNotFoundException {
        Optional<Occupation>  occupation =  occupationRepository.findByName(name);
		if(!occupation.isPresent())
		    throw new ResourceNotFoundException("Occupation not found with name :" + name);
		return  OccupationMapper.INSTANCE.OccupationToOccupationResponse(occupation.get());
	}

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
		
    	Occupation occupation = occupationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Occupation not found"));
		
    	occupation.getEmployee().getEmployeeOccupations().remove(occupation);
    	occupation.getJob().getJobOccupations().remove(occupation);
        occupationRepository.delete(occupation);
    }
}
