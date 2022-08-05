package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Job;
import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface JobMapper {

	JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
	
	Job JobRequestToJob(JobRequest JobRequest);
	JobResponse JobToJobResponse(Job job);
	List<JobResponse> mapReponse(List<Job> jobs);
}

