package com.giantlink.grh.services;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    
    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<Departement> findAll() {
        return departementRepository.findAll();
    }

    @Override
    public Departement findById(Long id) {
        return departementRepository.findById(id).get();
    }

    @Override
    public Departement save(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void delete(Long id) {
        departementRepository.deleteById(id);
    }
}
