package com.giantlink.grh.controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.services.CompanyEntityService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/company/entity")
public class CompanyEntityController {

	@Autowired
	CompanyEntityService companyEntityService;

	@GetMapping
	public ResponseEntity<List<CompanyEntityResponse>> get() {
		return new ResponseEntity<>(companyEntityService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CompanyEntityResponse> add(@RequestBody CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException {
		return new ResponseEntity<>(companyEntityService.add(companyEntityRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyEntityResponse> update(@PathVariable Integer id,
			@RequestBody @Valid CompanyEntityRequest companyEntityRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(companyEntityService.update(id, companyEntityRequest), HttpStatus.ACCEPTED);
	}

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntityResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(companyEntityService.get(id), HttpStatus.OK);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<CompanyEntityResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(companyEntityService.get(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	companyEntityService.delete(id);
        return new ResponseEntity<>("companyEntity deleted",HttpStatus.NO_CONTENT);
    }

}
