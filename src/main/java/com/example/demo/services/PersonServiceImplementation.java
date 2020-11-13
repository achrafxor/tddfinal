package com.example.demo.services;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonServiceImplementation implements InterfacePersonService {

    @Autowired
    PersonRepository personRepository;
    @Override
    public Person getPersonDetails(String eMail) {
        return personRepository.getOne(eMail);
    }
}
