package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.CompanyEntity;

@Repository
public interface CompanyEntityRepository extends JpaRepository<CompanyEntity, Integer> {

	Optional<CompanyEntity> findByName(String name);

}
