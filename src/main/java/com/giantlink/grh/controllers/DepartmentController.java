package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("departments")
public class DepartmentController {

	@Autowired
    private DepartementService departementService;

    @GetMapping("")
    public ResponseEntity<List<Departement>> findAll() {
         try {
            List<Departement> departements =  departementService.findAll();
            if (departements.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(departements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
        Departement departement = departementService.findById(id);
        if (departement != null )
            return new ResponseEntity<>(departement, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Departement> save(@RequestBody Departement departement) {
        return new ResponseEntity<>(departementService.save(departement),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Departement> update(@PathVariable Long id,@RequestBody Departement depart) {
        Departement departement = departementService.findById(id);
        if (departement != null) {
            depart.setId(id);
            return new ResponseEntity<>(departementService.save(depart), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            departementService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
