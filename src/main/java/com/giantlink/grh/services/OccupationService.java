package com.giantlink.grh.services;

import com.giantlink.grh.entities.Occupation;

import java.util.List;


public interface OccupationService {

    Occupation add(Occupation occupation);
	Occupation get(Integer id);
    List<Occupation> get();
    void delete(Integer id);
}
