package com.abnamro.assessment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.abnamro.assessment.entity.PersonEntity;
import com.abnamro.assessment.model.Person;
import com.abnamro.exception.PersonCustomException;
import com.abnamro.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonService
 */
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    List<String> bannedYears = new ArrayList<>();

    public void createPerson(Person p) {
        if(null == personRepository.findByName(p.getName())){
            personRepository.save(new PersonEntity(p.getName(),p.getBirthDate()));
        }else{
            throw new PersonCustomException("Duplicate Person names are not allowed") ;
        }
    }

    public List listFilteredPersons() {
        return personRepository.findAll().stream().filter(person->!bannedYears.contains(String.valueOf(person.getBirthDate().getYear())))
        .collect(Collectors.toList());
    }
    public void getBannedYears() throws IOException {
        try (InputStream in = getClass().getResourceAsStream("/banned-years");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            bannedYears = reader.lines().collect(Collectors.toList());
        }
    }
    
}