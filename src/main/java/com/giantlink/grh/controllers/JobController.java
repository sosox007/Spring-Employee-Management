package com.giantlink.grh.controllers;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;
import com.giantlink.grh.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
	public ResponseEntity<List<JobResponse>> get() {
		return new ResponseEntity<>(jobService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<JobResponse> add(@RequestBody JobRequest jobRequest) throws AlreadyExistsException {
		return new ResponseEntity<>(jobService.add(jobRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<JobResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(jobService.get(id), HttpStatus.OK);
    }

	@GetMapping("/name/{name}")
    public ResponseEntity<JobResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(jobService.get(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	jobService.delete(id);
        return new ResponseEntity<>("Job deleted",HttpStatus.OK);
    }

}
