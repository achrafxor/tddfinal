package com.example.demo.PersonRepositoryTest;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void getPerson_returnPersonDetails() throws Exception{
        Person person=personRepository.getOne("flen@softilys.tn");
        assertThat(person.getEmail()).isEqualTo("flen@softilys.tn");
        assertThat(person.getLastName()).isEqualTo("Ben Foulen");
        assertThat(person.getFirstName()).isEqualTo("Flen");

    }
    @Test
    void addPerson_returnPersonDetails()throws Exception{
        Person person=personRepository.save(new Person("achrafsaoud@outlook.com","achraf","saoud"));
        assertThat(person.getEmail()).isEqualTo("achrafsaoud@outlook.com");
        assertThat(person.getLastName()).isEqualTo("saoud");
        assertThat(person.getFirstName()).isEqualTo("achraf");
    }
}
