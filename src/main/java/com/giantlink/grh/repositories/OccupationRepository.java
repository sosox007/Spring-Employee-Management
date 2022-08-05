package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.entities.Occupation;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Integer>{
	Optional<Occupation> findByName(String name);
	long deleteByEmployee(Employee employee);
}
