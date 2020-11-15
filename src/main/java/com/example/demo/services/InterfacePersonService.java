package com.example.demo.services;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

public interface InterfacePersonService {
    public Person getPersonDetails(String eMail);
    public Person addPerson(Person person);

    Person updatePerson(Person person);
}
