package com.giantlink.grh.services;

import com.giantlink.grh.entities.Occupation;

import java.util.List;

public interface OccupationService {

    List<Occupation> findAll();
    Occupation findById(Long id);
    Occupation save(Occupation occupation);
    void delete(Long occupationId);
}
