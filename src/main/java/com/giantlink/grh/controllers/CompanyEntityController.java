package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.services.CompanyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("companyEntities")
public class CompanyEntityController {

    @Autowired
    private CompanyEntityService companyEntityService;

    @GetMapping("")
    public ResponseEntity<List<CompanyEntity>> findAll() {
         try {
            List<CompanyEntity> companyEntities =  companyEntityService.findAll();
            if (companyEntities.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(companyEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> getCompanyEntityById(@PathVariable Long id) {
        CompanyEntity companyEntity = companyEntityService.findById(id);
        if (companyEntity != null )
            return new ResponseEntity<>(companyEntity, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyEntity> save(@RequestBody CompanyEntity companyEntity) {
        return new ResponseEntity<>(companyEntityService.save(companyEntity),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyEntity> update(@PathVariable Long id,@RequestBody CompanyEntity compEnt) {
        CompanyEntity companyEntity = companyEntityService.findById(id);
        if (companyEntity != null) {
            compEnt.setId(id);
            return new ResponseEntity<>(companyEntityService.save(compEnt), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            companyEntityService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
