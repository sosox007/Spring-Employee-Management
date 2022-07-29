package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Job;
import com.giantlink.grh.services.JobService;
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
@RequestMapping("/api/v1/company/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
	public ResponseEntity<List<Job>> get() {
		return new ResponseEntity<List<Job>>(jobService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Job> add(@RequestBody Job job) {
		return new ResponseEntity<Job>(jobService.add(job), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Job> get(@PathVariable Integer id) {
        return new ResponseEntity<Job>(jobService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> update(@PathVariable Integer id,@RequestBody Job jo) {
        Job job = jobService.get(id);
        if (job != null) {
        	jo.setId(id);
            return new ResponseEntity<Job>(jobService.add(jo), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	jobService.delete(id);
        return new ResponseEntity<String>("Job deleted",HttpStatus.OK);
    }

}
