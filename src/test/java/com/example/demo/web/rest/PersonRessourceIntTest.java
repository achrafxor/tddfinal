package com.example.demo.web.rest;

import com.example.demo.DemoApplication;
import com.example.demo.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonRessourceIntTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    void getPerson_ReturnPersonDetails(){
        //Given

        //when
        ResponseEntity<Person> response=testRestTemplate.getForEntity("/person/flen@softilys.tn",Person.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getEmail()).isEqualTo("flen@softilys.tn");
        Assertions.assertThat(response.getBody().getLastName()).isEqualTo("Ben Foulen");
        Assertions.assertThat(response.getBody().getFirstName()).isEqualTo("Flen");

    }
    @Test
    void addPerson_ReturnPersonDetails(){

    }
}
