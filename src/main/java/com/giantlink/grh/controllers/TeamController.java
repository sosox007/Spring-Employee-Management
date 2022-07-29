package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
   
    @GetMapping
	public ResponseEntity<List<Team>> get() {
		return new ResponseEntity<List<Team>>(teamService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Team> add(@RequestBody Team team) {
		return new ResponseEntity<Team>(teamService.add(team), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Team> get(@PathVariable Integer id) {
        return new ResponseEntity<Team>(teamService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> update(@PathVariable Integer id,@RequestBody Team te) {
        Team team = teamService.get(id);
        if (team != null) {
        	te.setId(id);
            return new ResponseEntity<Team>(teamService.add(te), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	teamService.delete(id);
        return new ResponseEntity<String>("Team deleted",HttpStatus.OK);
    }

}
