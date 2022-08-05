package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OccupationMapper {

	OccupationMapper INSTANCE = Mappers.getMapper(OccupationMapper.class);
	
	Occupation OccupationRequestToOccupation(OccupationRequest OccupationRequest);
	OccupationResponse OccupationToOccupationResponse(Occupation Occupation);
	List<OccupationResponse> mapReponse(List<Occupation> occupations);
}

