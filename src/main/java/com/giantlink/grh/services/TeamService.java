package com.giantlink.grh.services;

import com.giantlink.grh.entities.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAll();
    Team findById(Long id);
    Team save(Team team);
    void delete(Long teamId);
}
