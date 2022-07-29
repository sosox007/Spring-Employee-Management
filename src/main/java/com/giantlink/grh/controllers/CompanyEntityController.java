package com.giantlink.grh.controllers;

import java.util.List;

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

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.services.CompanyEntityService;

@RestController
@RequestMapping("/api/v1/company/entity")
public class CompanyEntityController {

	@Autowired
	CompanyEntityService companyEntityService;

	@GetMapping
	public ResponseEntity<List<CompanyEntity>> get() {
		return new ResponseEntity<List<CompanyEntity>>(companyEntityService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CompanyEntity> add(@RequestBody CompanyEntity companyEntity) {
		return new ResponseEntity<CompanyEntity>(companyEntityService.add(companyEntity), HttpStatus.CREATED);
	}

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> get(@PathVariable Integer id) {
        return new ResponseEntity<CompanyEntity>(companyEntityService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyEntity> update(@PathVariable Integer id,@RequestBody CompanyEntity compEnt) {
        CompanyEntity companyEntity = companyEntityService.get(id);
        if (companyEntity != null) {
        	compEnt.setId(id);
            return new ResponseEntity<CompanyEntity>(companyEntityService.add(compEnt), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	companyEntityService.delete(id);
        return new ResponseEntity<String>("companyEntity deleted",HttpStatus.OK);
    }

}
