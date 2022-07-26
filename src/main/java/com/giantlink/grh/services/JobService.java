package com.giantlink.grh.services;

import com.giantlink.grh.entities.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    Job findById(Long id);
    Job save(Job job);
    void delete(Long jobId);
}
