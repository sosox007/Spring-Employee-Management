package com.giantlink.grh.controllers;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;
import com.giantlink.grh.services.OccupationService;
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
@RequestMapping("/api/v1/company/occupation")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @GetMapping
	public ResponseEntity<List<OccupationResponse>> get() {
		return new ResponseEntity<>(occupationService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OccupationResponse> add(@RequestBody OccupationRequest occupationRequest) throws AlreadyExistsException {
		return new ResponseEntity<>(occupationService.add(occupationRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<OccupationResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(occupationService.get(id), HttpStatus.OK);
    }

	@GetMapping("/name/{name}")
    public ResponseEntity<OccupationResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(occupationService.get(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	occupationService.delete(id);
        return new ResponseEntity<>("Occupation deleted",HttpStatus.OK);
    }

}
