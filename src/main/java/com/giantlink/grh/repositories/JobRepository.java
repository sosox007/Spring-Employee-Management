package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{

	Optional<Job> findByName(String name);
}
