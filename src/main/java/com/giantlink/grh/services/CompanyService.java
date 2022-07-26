package com.giantlink.grh.services;

import com.giantlink.grh.entities.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    Company findById(Long id);
    Company save(Company company);
    void delete(Long companyId);

}
