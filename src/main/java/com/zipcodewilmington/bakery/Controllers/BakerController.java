package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Baker;
import com.zipcodewilmington.bakery.Repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BakerController {

    @Autowired
    private BakerRepository bakerRepository;


    @GetMapping(path = "/bakers")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(this.bakerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/bakers/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.bakerRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping(path = "/bakers")
    public ResponseEntity<Baker> create(Baker baker) {
        return new ResponseEntity<>(this.bakerRepository.save(baker), HttpStatus.CREATED);
    }

    @PutMapping(path = "/bakers/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id, Baker baker) {
        Baker foundBaker = bakerRepository.findById(id).get();

        foundBaker.setName(baker.getName());
        foundBaker.setSpecialty(baker.getSpecialty());

        return new ResponseEntity<>(this.bakerRepository.save(foundBaker), HttpStatus.OK);
    }

    @DeleteMapping(path = "/bakers/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.bakerRepository.findById(id).get();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
