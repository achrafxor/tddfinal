package com.example.demo.web.rest;

import com.example.demo.model.Person;
import com.example.demo.services.PersonServiceImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServiceImplementation personService;

    @Test
    void getPerson_ReturnPersonsDetails() throws Exception {
        given(personService.getPersonDetails("flen@softilys.tn")).willReturn(new Person("flen@softilys.tn", "Flen", "Ben Foulen"));
        mockMvc.perform(MockMvcRequestBuilders.get("/person/flen@softilys.tn")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("firstName").value("Flen"))
                .andExpect(jsonPath("lastName").value("Ben Foulen"))
                .andExpect(jsonPath("email").value("flen@softilys.tn"));
    }

    @Test
    void addPerson_ReturnPersonDetails() throws Exception {
        Person person = new Person("achrafsaoud@outlook.com", "achraf", "saoud");
        given(personService.addPerson(new Person("achrafsaoud@outlook.com", "achraf", "saoud"))).willReturn(person);
        mockMvc.perform(MockMvcRequestBuilders.post("/person/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(person)))
                .andExpect(status().isOk()).andDo(print());

    }
    @Test
    void updatePerson_RetutnPersonDetails() throws Exception{
        Person person = new Person("achrafsaoud@outlook.com", "achraf", "saoud");
        given(personService.updatePerson(new Person("achrafsaoud@outlook.com","achraf","saoud"))).willReturn(person);
        mockMvc.perform(MockMvcRequestBuilders.put("/person/update")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(person)))
        .andExpect(status().isOk()).andDo(print());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
