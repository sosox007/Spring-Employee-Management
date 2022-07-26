package com.giantlink.grh.services;

import com.giantlink.grh.entities.Employee;

import java.util.List;

public interface EmployeeSerivce {

    List<Employee> findAll();
    Employee findById(Long id);
    Employee save(Employee employee);
    void delete(Long employeeId);
    
}