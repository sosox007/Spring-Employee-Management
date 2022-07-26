package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Job;
import com.giantlink.grh.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("")
    public ResponseEntity<List<Job>> findAll() {
         try {
            List<Job> jobs =  jobService.findAll();
            if (jobs.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job != null )
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Job> save(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.save(job),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Job> update(@PathVariable Long id,@RequestBody Job jo) {
        Job job = jobService.findById(id);
        if (job != null) {
            jo.setId(id);
            return new ResponseEntity<>(jobService.save(jo), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            jobService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
