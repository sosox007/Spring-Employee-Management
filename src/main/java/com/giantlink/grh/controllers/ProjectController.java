package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Project;
import com.giantlink.grh.services.ProjectService;
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
@RequestMapping("/api/v1/company/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
   
    @GetMapping
	public ResponseEntity<List<Project>> get() {
		return new ResponseEntity<List<Project>>(projectService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Project> add(@RequestBody Project project) {
		return new ResponseEntity<Project>(projectService.add(project), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Integer id) {
        return new ResponseEntity<Project>(projectService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Integer id,@RequestBody Project pro) {
        Project project = projectService.get(id);
        if (project != null) {
        	pro.setId(id);
            return new ResponseEntity<Project>(projectService.add(pro), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	projectService.delete(id);
        return new ResponseEntity<String>("Project deleted",HttpStatus.OK);
    }

}
