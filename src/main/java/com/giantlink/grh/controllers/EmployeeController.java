package com.giantlink.grh.controllers;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;
import com.giantlink.grh.services.EmployeeSerivce;
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
@RequestMapping("/api/v1/company/employee")
public class EmployeeController {

    @Autowired
    private EmployeeSerivce employeeSerivce;

    @GetMapping
	public ResponseEntity<List<EmployeeResponse>> get() {
		return new ResponseEntity<>(employeeSerivce.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> add(@RequestBody EmployeeRequest employeerequest) throws AlreadyExistsException {
		return new ResponseEntity<>(employeeSerivce.add(employeerequest), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeSerivce.get(id), HttpStatus.OK);
    }
	
	@GetMapping("/name/{name}")
    public ResponseEntity<EmployeeResponse> get(@PathVariable String name) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeSerivce.get(name), HttpStatus.OK);
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
    	employeeSerivce.delete(id);
        return new ResponseEntity<>("Employee deleted",HttpStatus.OK);
    }

}
