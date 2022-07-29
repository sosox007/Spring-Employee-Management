package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.services.DepartementService;
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
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/company/departement")
public class DepartementController {

	@Autowired
    DepartementService departementService;

    @GetMapping
	public ResponseEntity<List<Departement>> get() {
		return new ResponseEntity<List<Departement>>(departementService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Departement> add(@RequestBody Departement departement) {
		return new ResponseEntity<Departement>(departementService.add(departement), HttpStatus.CREATED);
	}

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Departement>> get(@PathVariable String name) {
        return new ResponseEntity<Optional<Departement>>(departementService.get(name), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Departement> get(@PathVariable Integer id) {
        return new ResponseEntity<Departement>(departementService.get(id), HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Departement> update(@PathVariable Integer id,@RequestBody Departement dep) {
        Departement departement = departementService.get(id);
        if (departement != null) {
        	dep.setId(id);
            return new ResponseEntity<Departement>(departementService.add(dep), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    	departementService.delete(id);
        return new ResponseEntity<String>("Departement deleted",HttpStatus.OK);
    }

}
