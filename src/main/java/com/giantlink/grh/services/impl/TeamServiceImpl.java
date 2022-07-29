package com.giantlink.grh.services.impl;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.repositories.TeamRepository;
import com.giantlink.grh.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> get() {
        return teamRepository.findAll();
    }

    @Override
    public Team get(Integer id) {
        return teamRepository.findById(id).get();
    }
    
    @Override
	public Team add(Team team) {
		return teamRepository.save(team);
	}
    
    @Override
    public void delete(Integer id) {
        teamRepository.deleteById(id);
    }

}
