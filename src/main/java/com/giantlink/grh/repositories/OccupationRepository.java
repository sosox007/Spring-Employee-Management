package com.giantlink.grh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Occupation;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Integer>{
}
