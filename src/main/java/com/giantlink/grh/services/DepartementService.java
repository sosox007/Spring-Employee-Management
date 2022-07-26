package com.giantlink.grh.services;

import com.giantlink.grh.entities.Departement;

import java.util.List;

public interface DepartementService {

    List<Departement> findAll();
    Departement findById(Long id);
    Departement save(Departement departement);
    void delete(Long departementId);

}
