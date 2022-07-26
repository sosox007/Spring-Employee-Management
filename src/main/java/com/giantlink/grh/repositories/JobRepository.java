package com.giantlink.grh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
}
