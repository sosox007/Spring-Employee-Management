package com.giantlink.grh.services;

import com.giantlink.grh.entities.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();
    Project findById(Long id);
    Project save(Project company);
    void delete(Long projectId);
}
