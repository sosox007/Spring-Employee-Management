package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
	Optional<Departement> findByName(String name);
}
