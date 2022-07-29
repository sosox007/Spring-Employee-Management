package com.giantlink.grh.services;

import com.giantlink.grh.entities.Employee;

import java.util.List;


public interface EmployeeSerivce {

    Employee add(Employee employee);
	Employee get(Integer id);
	List<Employee> get();
    void delete(Integer id);
    
}