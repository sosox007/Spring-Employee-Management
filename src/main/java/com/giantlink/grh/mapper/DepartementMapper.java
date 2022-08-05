package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DepartementMapper {

	DepartementMapper INSTANCE = Mappers.getMapper(DepartementMapper.class);
	
	Departement DepartementRequestToDepartement(DepartementRequest DepartementRequest);
	DepartementResponse DepartementToDepartementResponse(Departement Departement);
	List<DepartementResponse> mapReponse(List<Departement> departements);
}

