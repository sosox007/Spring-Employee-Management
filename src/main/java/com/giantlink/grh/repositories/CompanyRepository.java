package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Optional<Company> findByName(String name);

}
