package com.giantlink.grh.controllers;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;
import com.giantlink.grh.services.DepartementService;
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
@RequestMapping("/api/v1/company/departement")
public class DepartementController {

	@Autowired
    DepartementService departementService;

    @GetMapping
	public ResponseEntity<List<DepartementResponse>> get() {
		return new ResponseEntity<>(departementService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DepartementResponse> add(@RequestBody DepartementRequest departementrequest) throws AlreadyExistsException {
		return new ResponseEntity<>(departementService.add(departementrequest), HttpStatus.CREATED);
	}

    @GetMapping("/name/{name}")
    public ResponseEntity<DepartementResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(departementService.get(name), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DepartementResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(departementService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	departementService.delete(id);
        return new ResponseEntity<>("Departement deleted",HttpStatus.OK);
    }

}
