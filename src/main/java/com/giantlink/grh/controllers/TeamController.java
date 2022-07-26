package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("teams")
public class TeamController {

    @Autowired
    private TeamService teamService;
   
    @GetMapping("")
    public ResponseEntity<List<Team>> findAll() {
         try {
            List<Team> teams =  teamService.findAll();
            if (teams.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = teamService.findById(id);
        if (team != null )
            return new ResponseEntity<>(team, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Team> save(@RequestBody Team team) {
        return new ResponseEntity<>(teamService.save(team),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Team> update(@PathVariable Long id,@RequestBody Team te) {
        Team team = teamService.findById(id);
        if (team != null) {
            te.setId(id);
            return new ResponseEntity<>(teamService.save(te), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            teamService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
