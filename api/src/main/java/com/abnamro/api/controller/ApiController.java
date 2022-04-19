package com.abnamro.api.controller;

import com.abnamro.assessment.model.Person;
import com.abnamro.assessment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ApiController{

    Logger logger= LoggerFactory.getLogger(ApiController.class);
    @Autowired
    private PersonService personService;

    @PostMapping("/person")  
	public ResponseEntity<String> createPerson(@RequestBody Person person)  
	{  
		logger.info("createPerson called.");
		if(null== person) {
			personService.createPerson(person);
        return new ResponseEntity(HttpStatus.CREATED);
		}else {
			logger.error("Error in creation");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}

    @GetMapping("/allFilteredPersons")
	public ResponseEntity<List<Person>> getAllPersons(){
		logger.info("getfiltered persons called.");
		return new ResponseEntity<>(personService.listFilteredPersons(),HttpStatus.OK);
	}
}