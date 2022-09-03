package com.giantlink.grh.services;

import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.DepartementResponse;
import com.giantlink.grh.models.responses.EmployeeResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

import java.util.List;


public interface EmployeeSerivce {

	EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistsException;
	EmployeeResponse get(Integer id) throws ResourceNotFoundException;
	EmployeeResponse get(String name) throws ResourceNotFoundException;
	List<EmployeeResponse> get();
    void delete(Integer id) throws ResourceNotFoundException;
    EmployeeResponse update(Integer id, EmployeeRequest employeeRequest) throws ResourceNotFoundException;
    
}