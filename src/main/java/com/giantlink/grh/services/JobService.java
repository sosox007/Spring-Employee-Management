package com.giantlink.grh.services;

import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

import java.util.List;


public interface JobService {

	JobResponse add(JobRequest JobRequest) throws AlreadyExistsException;
	JobResponse get(Integer id) throws ResourceNotFoundException;
	JobResponse get(String name) throws ResourceNotFoundException;
	List<JobResponse> get();
    void delete(Integer id) throws ResourceNotFoundException;
}
