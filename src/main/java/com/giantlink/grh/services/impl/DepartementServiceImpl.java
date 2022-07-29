package com.giantlink.grh.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.repositories.DepartementRepository;
import com.giantlink.grh.services.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	private DepartementRepository departementRepository;

	@Override
	public Departement add(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement get(Integer id) {
		return departementRepository.findById(id).get();
	}

	@Override
	public  Optional<Departement> get(String name) {
		Optional<Departement> departement = Optional.of(departementRepository.findByName(name).get());
		return departement;
	}

	@Override
	public List<Departement> get() {
		return departementRepository.findAll();
	}

	@Override
    public void delete(Integer id) {
    	departementRepository.deleteById(id);
    }

}
