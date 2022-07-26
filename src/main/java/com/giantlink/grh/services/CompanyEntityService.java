package com.giantlink.grh.services;


import com.giantlink.grh.entities.CompanyEntity;

import java.util.List;

public interface CompanyEntityService {

    List<CompanyEntity> findAll();
    CompanyEntity findById(Long id);
    CompanyEntity save(CompanyEntity companyEntity);
    void delete(Long companyEntityId);

}
