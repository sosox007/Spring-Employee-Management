package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {

	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	Employee EmployeeRequestToEmployee(EmployeeRequest EmployeeRequest);
	EmployeeResponse EmployeeToEmployeeResponse(Employee Employee);
	List<EmployeeResponse> mapReponse(List<Employee> departements);
}

