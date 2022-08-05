package com.giantlink.grh.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.services.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<CompanyResponse>> get() {
		return new ResponseEntity<>(companyService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CompanyResponse> add(@RequestBody @Valid CompanyRequest companyRequest) throws AlreadyExistsException {
		return new ResponseEntity<>(companyService.add(companyRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(companyService.get(id), HttpStatus.OK);
    }
	
	@GetMapping("/name/{name}")
    public ResponseEntity<CompanyResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(companyService.get(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	companyService.delete(id);
        return new ResponseEntity<>("Company deleted",HttpStatus.OK);
    }

}
