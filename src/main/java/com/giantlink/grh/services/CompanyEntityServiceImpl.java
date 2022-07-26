package com.giantlink.grh.services;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.repositories.CompanyEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyEntityServiceImpl implements CompanyEntityService {

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    @Override
    public List<CompanyEntity> findAll() {
        return companyEntityRepository.findAll();
    }

    @Override
    public CompanyEntity findById(Long id) {
        return companyEntityRepository.findById(id).get();
    }

    @Override
    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyEntityRepository.save(companyEntity);
    }

    @Override
    public void delete(Long id) {
        companyEntityRepository.deleteById(id);
    }
}
