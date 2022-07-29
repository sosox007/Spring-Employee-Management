package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.services.EmployeeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<Employee>> get() {
		return new ResponseEntity<List<Employee>>(employeeSerivce.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> add(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeSerivce.add(employee), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        return new ResponseEntity<Employee>(employeeSerivce.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id,@RequestBody Employee emp) {
        Employee employee = employeeSerivce.get(id);
        if (employee != null) {
        	emp.setId(id);
            return new ResponseEntity<Employee>(employeeSerivce.add(emp), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	employeeSerivce.delete(id);
        return new ResponseEntity<String>("Employee deleted",HttpStatus.OK);
    }

}
