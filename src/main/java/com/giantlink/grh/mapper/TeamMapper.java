package com.giantlink.grh.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.TeamResponse;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TeamMapper {

	TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
	
	Team TeamRequestToTeam(TeamRequest TeamRequest);
	TeamResponse TeamToTeamResponse(Team Team);
	List<TeamResponse> mapReponse(List<Team> teams);
}

