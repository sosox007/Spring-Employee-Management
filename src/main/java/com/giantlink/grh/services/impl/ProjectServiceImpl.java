package com.giantlink.grh.services.impl;

import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;
import com.giantlink.grh.entities.Project;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.ProjectMapper;
import com.giantlink.grh.repositories.ProjectRepository;
import com.giantlink.grh.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
	
	@Override
	public ProjectResponse add(ProjectRequest projectRequest) throws AlreadyExistsException {
	
		Project project =  ProjectMapper.INSTANCE.ProjectRequestToProject(projectRequest);
		if (projectRepository.findByName(project.getName()).isPresent())
			throw new AlreadyExistsException(Project.class.getSimpleName(), projectRequest.getName() + " Already Exists !");	
		
		return  ProjectMapper.INSTANCE.ProjectToProjectResponse(projectRepository.save(project));
	}


	@Override
	public List<ProjectResponse> get() {
		return ProjectMapper.INSTANCE.mapReponse(projectRepository.findAll());
	}

	@Override
	public ProjectResponse get(Integer id) throws ResourceNotFoundException {
        Optional<Project>  project =  projectRepository.findById(id);
		if(!project.isPresent())
		    throw new ResourceNotFoundException("Project not found with id :" + id);
		return  ProjectMapper.INSTANCE.ProjectToProjectResponse(project.get());
	}

    @Override
	public ProjectResponse get(String name) throws ResourceNotFoundException {
        Optional<Project>  project =  projectRepository.findByName(name);
		if(!project.isPresent())
		    throw new ResourceNotFoundException("Project not found with name :" + name);
		return  ProjectMapper.INSTANCE.ProjectToProjectResponse(project.get());
	}

    @Override
    public void delete(Integer id)  throws ResourceNotFoundException {
		
    	Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    	
        projectRepository.delete(project);
    }
}
