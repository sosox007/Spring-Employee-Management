package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.DepartementMapper;
import com.giantlink.grh.mapper.EmployeeMapper;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.DepartementResponse;
import com.giantlink.grh.models.responses.EmployeeResponse;
import com.giantlink.grh.repositories.EmployeeRepository;
import com.giantlink.grh.repositories.TeamRepository;
import com.giantlink.grh.services.EmployeeSerivce;

@Service
public class EmployeeSerivceImpl implements EmployeeSerivce {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistsException {

		Employee employee = EmployeeMapper.INSTANCE.EmployeeRequestToEmployee(employeeRequest);
		if (employeeRepository.findByName(employee.getName()).isPresent())
			throw new AlreadyExistsException(Employee.class.getSimpleName(),
					employeeRequest.getName() + " Already Exists !");

		employee.setTeam(teamRepository.findById(employeeRequest.getTeam_id()).get());
		return EmployeeMapper.INSTANCE.EmployeeToEmployeeResponse(employeeRepository.save(employee));
	}

	@Override
	public EmployeeResponse update(Integer id, EmployeeRequest employeeRequest) throws ResourceNotFoundException {
	
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent())
			throw new ResourceNotFoundException("Employee not found with id :" + id);
	
		employee.get().setName(employeeRequest.getName());
		employee.get().setTeam(teamRepository.findById(employeeRequest.getTeam_id()).get());
		return EmployeeMapper.INSTANCE.EmployeeToEmployeeResponse(employeeRepository.save(employee.get()));
	}
	
	
	@Override
	public List<EmployeeResponse> get() {
		return EmployeeMapper.INSTANCE.mapReponse(employeeRepository.findAll());
	}

	@Override
	public EmployeeResponse get(Integer id) throws ResourceNotFoundException {

		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent())
			throw new ResourceNotFoundException("Employee not found with id :" + id);
		return EmployeeMapper.INSTANCE.EmployeeToEmployeeResponse(employee.get());
	}

	@Override
	public EmployeeResponse get(String name) throws ResourceNotFoundException {

		Optional<Employee> employee = employeeRepository.findByName(name);
		if (!employee.isPresent())
			throw new ResourceNotFoundException("Employee not found with name :" + name);
		return EmployeeMapper.INSTANCE.EmployeeToEmployeeResponse(employee.get());
	}

	@Override
	public void delete(Integer id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		employeeRepository.delete(employee);
	}
}
