package com.giantlink.grh.services;
import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

import java.util.List;


public interface ProjectService {

	ProjectResponse add(ProjectRequest ProjectRequest) throws AlreadyExistsException;
	ProjectResponse get(Integer id) throws ResourceNotFoundException;
	ProjectResponse get(String name) throws ResourceNotFoundException;
	List<ProjectResponse> get();
    void delete(Integer id) throws ResourceNotFoundException;
}
