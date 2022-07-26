package com.giantlink.grh.services;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.repositories.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService{
	
    @Autowired
    private OccupationRepository occupationRepository;

    @Override
    public List<Occupation> findAll() {
        return occupationRepository.findAll();
    }

    @Override
    public Occupation findById(Long id) {
        return occupationRepository.findById(id).get();
    }

    @Override
    public Occupation save(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    @Override
    public void delete(Long id) {
        occupationRepository.deleteById(id);
    }
}
