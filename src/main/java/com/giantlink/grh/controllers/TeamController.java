package com.giantlink.grh.controllers;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;
import com.giantlink.grh.models.responses.TeamResponse;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/company/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
   
    @GetMapping
	public ResponseEntity<List<TeamResponse>> get() {
		return new ResponseEntity<>(teamService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TeamResponse> add(@RequestBody TeamRequest teamRequest) throws AlreadyExistsException {
		return new ResponseEntity<>(teamService.add(teamRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TeamResponse> update(@PathVariable Integer id,
			@RequestBody @Valid TeamRequest teamRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(teamService.update(id, teamRequest), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<TeamResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(teamService.get(id), HttpStatus.OK);
    }

	@GetMapping("/name/{name}")
    public ResponseEntity<TeamResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(teamService.get(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	teamService.delete(id);
        return new ResponseEntity<String>("Team deleted",HttpStatus.NO_CONTENT);
    }

}
