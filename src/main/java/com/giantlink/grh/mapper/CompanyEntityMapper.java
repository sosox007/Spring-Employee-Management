package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompanyEntityMapper {

	CompanyEntityMapper INSTANCE = Mappers.getMapper(CompanyEntityMapper.class);
	
	CompanyEntity CompanyEntityRequestToCompanyEntity(CompanyEntityRequest CompanyEntityRequest);
	CompanyEntityResponse CompanyEntityToCompanyEntityResponse(CompanyEntity CompanyEntity);
	List<CompanyEntityResponse> mapReponse(List<CompanyEntity> companyEntities);
}

