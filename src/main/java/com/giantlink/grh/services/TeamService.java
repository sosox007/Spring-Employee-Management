package com.giantlink.grh.services;

import com.giantlink.grh.entities.Team;

import java.util.List;


public interface TeamService {

    Team add(Team team);
	Team get(Integer id);
	List<Team> get();
    void delete(Integer id);
}
