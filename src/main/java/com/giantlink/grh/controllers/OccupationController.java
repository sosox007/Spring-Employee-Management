package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.services.OccupationService;
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
@RequestMapping("/api/v1/company/occupation")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @GetMapping
	public ResponseEntity<List<Occupation>> get() {
		return new ResponseEntity<List<Occupation>>(occupationService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Occupation> add(@RequestBody Occupation occupation) {
		return new ResponseEntity<Occupation>(occupationService.add(occupation), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Occupation> get(@PathVariable Integer id) {
        return new ResponseEntity<Occupation>(occupationService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Occupation> update(@PathVariable Integer id,@RequestBody Occupation occup) {
        Occupation occupation = occupationService.get(id);
        if (occupation != null) {
        	occup.setId(id);
            return new ResponseEntity<Occupation>(occupationService.add(occup), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	occupationService.delete(id);
        return new ResponseEntity<String>("Occupation deleted",HttpStatus.OK);
    }

}
