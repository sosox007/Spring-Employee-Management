package com.giantlink.grh.controllers;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;
import com.giantlink.grh.services.ProjectService;
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
@RequestMapping("/api/v1/company/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
   
    @GetMapping
	public ResponseEntity<List<ProjectResponse>> get() {
		return new ResponseEntity<>(projectService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProjectResponse> add(@RequestBody ProjectRequest projectRequest) throws AlreadyExistsException {
		return new ResponseEntity<>(projectService.add(projectRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(projectService.get(id), HttpStatus.OK);
    }

	@GetMapping("/name/{name}")
    public ResponseEntity<ProjectResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(projectService.get(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	projectService.delete(id);
        return new ResponseEntity<String>("Project deleted",HttpStatus.OK);
    }

}
