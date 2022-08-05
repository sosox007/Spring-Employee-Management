package com.giantlink.grh.services;
import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.TeamResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;

import java.util.List;


public interface TeamService {

	TeamResponse add(TeamRequest TeamRequest) throws AlreadyExistsException;
	TeamResponse get(Integer id) throws ResourceNotFoundException;
	TeamResponse get(String name) throws ResourceNotFoundException;
	List<TeamResponse> get();
    void delete(Integer id) throws ResourceNotFoundException;
}
