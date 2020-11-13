package com.example.demo.PersonServiceTest;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import com.example.demo.services.InterfacePersonService;
import com.example.demo.services.PersonServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonServiceImplementation personServiceImplementation;
    @Mock
    private PersonRepository personRepository;

    @Test
    void getPerson_returnPersonDetails() throws Exception{
        when(personRepository.getOne(anyString()))
                .thenReturn(new Person("flen@softilys.tn","Flen","Ben Foulen"));
        assertThat(personServiceImplementation.getPersonDetails(anyString()))
                .isEqualToComparingFieldByField(personRepository.getOne(anyString()));
    }
}
