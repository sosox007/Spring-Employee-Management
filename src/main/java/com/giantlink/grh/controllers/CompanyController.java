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

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.services.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<Company>> get() {
		return new ResponseEntity<List<Company>>(companyService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Company> add(@RequestBody Company company) {
		return new ResponseEntity<Company>(companyService.add(company), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Company> get(@PathVariable Integer id) {
        return new ResponseEntity<Company>(companyService.get(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Integer id,@RequestBody Company comp) {
        Company company = companyService.get(id);
        if (company != null) {
            comp.setId(id);
            return new ResponseEntity<Company>(companyService.add(comp), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	companyService.delete(id);
        return new ResponseEntity<String>("Company deleted",HttpStatus.OK);
    }

}
