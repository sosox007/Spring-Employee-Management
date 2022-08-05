package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Project;
import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectMapper {

	ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
	
	Project ProjectRequestToProject(ProjectRequest ProjectRequest);
	ProjectResponse ProjectToProjectResponse(Project Project);
	List<ProjectResponse> mapReponse(List<Project> projects);
}

