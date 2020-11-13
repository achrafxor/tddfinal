package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name = "person")
public class Person {

    @Id
    private String email;
    private String firstName;
    private String lastName;

    public Person(String email, String firstName, String lastName) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public Person(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
