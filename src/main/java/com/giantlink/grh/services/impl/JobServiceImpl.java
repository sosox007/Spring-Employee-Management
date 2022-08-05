package com.giantlink.grh.services.impl;


import com.giantlink.grh.entities.Job;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.JobMapper;
import com.giantlink.grh.repositories.JobRepository;
import com.giantlink.grh.services.JobService;
import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;
	
	@Override
	public JobResponse add(JobRequest jobRequest) throws AlreadyExistsException {
	
		Job job =  JobMapper.INSTANCE.JobRequestToJob(jobRequest);
		if (jobRepository.findByName(job.getName()).isPresent())
			throw new AlreadyExistsException(Job.class.getSimpleName(), jobRequest.getName() + " Already Exists !");	
		
		return  JobMapper.INSTANCE.JobToJobResponse(jobRepository.save(job));
	}

	@Override
	public List<JobResponse> get() {
		return JobMapper.INSTANCE.mapReponse(jobRepository.findAll());
	}

	@Override
	public JobResponse get(Integer id) throws ResourceNotFoundException {
        Optional<Job> job = jobRepository.findById(id);
		if(!job.isPresent())
		    throw new ResourceNotFoundException("Job not found with id :" + id);
		return  JobMapper.INSTANCE.JobToJobResponse(job.get());
	}

    @Override
	public JobResponse get(String name) throws ResourceNotFoundException {
        Optional<Job> job = jobRepository.findByName(name);
		if(!job.isPresent())
		    throw new ResourceNotFoundException("Job not found with name :" + name);
		return  JobMapper.INSTANCE.JobToJobResponse(job.get());
	}

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
		
		Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
		job.getProject().getJobs().remove(job);
        jobRepository.delete(job);
    }
}
