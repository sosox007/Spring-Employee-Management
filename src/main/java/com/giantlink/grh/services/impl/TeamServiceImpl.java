package com.giantlink.grh.services.impl;

import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.TeamResponse;
import com.giantlink.grh.entities.Team;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;
import com.giantlink.grh.mapper.TeamMapper;
import com.giantlink.grh.repositories.TeamRepository;
import com.giantlink.grh.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
	
	@Override
	public TeamResponse add(TeamRequest teamRequest) throws AlreadyExistsException {
	
		Team team =  TeamMapper.INSTANCE.TeamRequestToTeam(teamRequest);
		if (teamRepository.findByName(team.getName()).isPresent())
			throw new AlreadyExistsException(Team.class.getSimpleName(), teamRequest.getName() + " Already Exists !");	
		
		return  TeamMapper.INSTANCE.TeamToTeamResponse(teamRepository.save(team));
	}


	@Override
	public List<TeamResponse> get() {
		return TeamMapper.INSTANCE.mapReponse(teamRepository.findAll());
	}

	@Override
	public TeamResponse get(Integer id) throws ResourceNotFoundException {
        Optional<Team>  team =  teamRepository.findById(id);
		if(!team.isPresent())
		    throw new ResourceNotFoundException("Team not found with id :" + id);
		return  TeamMapper.INSTANCE.TeamToTeamResponse(team.get());
	}

    @Override
	public TeamResponse get(String name) throws ResourceNotFoundException {
        Optional<Team>  team =  teamRepository.findByName(name);
		if(!team.isPresent())
		    throw new ResourceNotFoundException("Team not found with name :" + name);
		return  TeamMapper.INSTANCE.TeamToTeamResponse(team.get());
	}

    @Override
    public void delete(Integer id)  throws ResourceNotFoundException {
		
    	Team team = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team not found"));
    	
    	team.getDepartement().getTeams().remove(team);
        teamRepository.delete(team);
    }

}
