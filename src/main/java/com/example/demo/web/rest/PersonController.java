package com.example.demo.web.rest;

import com.example.demo.model.Person;
import com.example.demo.services.PersonServiceImplementation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonServiceImplementation personService;

    @GetMapping("person/{email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email){
       return ResponseEntity.ok(personService.getPersonDetails(email));
    }
    @PostMapping("person/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
       return ResponseEntity.ok(personService.addPerson(person));
    }
    @PutMapping("person/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        return ResponseEntity.ok(personService.updatePerson(person));
    }
}
