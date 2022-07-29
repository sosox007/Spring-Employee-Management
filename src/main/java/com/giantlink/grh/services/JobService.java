package com.giantlink.grh.services;

import com.giantlink.grh.entities.Job;

import java.util.List;


public interface JobService {

    Job add(Job job);	
    Job get(Integer id);
	List<Job> get();
    void delete(Integer id);
}
