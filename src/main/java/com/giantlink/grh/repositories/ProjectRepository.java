package com.giantlink.grh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
}
