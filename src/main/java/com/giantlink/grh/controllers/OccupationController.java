package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.services.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("occupations")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @GetMapping("")
    public ResponseEntity<List<Occupation>> findAll() {
         try {
            List<Occupation> occupations =  occupationService.findAll();
            if (occupations.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(occupations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Occupation> getOccupationById(@PathVariable Long id) {
        Occupation occupation = occupationService.findById(id);
        if (occupation != null )
            return new ResponseEntity<>(occupation, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Occupation> save(@RequestBody Occupation occupation) {
        return new ResponseEntity<>(occupationService.save(occupation),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Occupation> update(@PathVariable Long id,@RequestBody Occupation occup) {
        Occupation occupation = occupationService.findById(id);
        if (occupation != null) {
            occup.setId(id);
            return new ResponseEntity<>(occupationService.save(occup), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            occupationService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
