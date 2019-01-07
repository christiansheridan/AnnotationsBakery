package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Muffin;
import com.zipcodewilmington.bakery.Repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {

    @Autowired
    private MuffinRepository muffinRepository;

    @GetMapping(path = "/muffins")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(this.muffinRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/muffins/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.muffinRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping(path = "/muffins")
    public ResponseEntity<Muffin> create(Muffin muffin) {
        return new ResponseEntity<>(this.muffinRepository.save(muffin), HttpStatus.CREATED);
    }

    @PutMapping(path = "/muffins/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, Muffin muffin) {
        Muffin foundMuffin = muffinRepository.findById(id).get();
        foundMuffin.setFlavor(muffin.getFlavor());

        return new ResponseEntity<>(this.muffinRepository.save(foundMuffin), HttpStatus.OK);
    }

    @DeleteMapping(path = "/muffins/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.muffinRepository.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
