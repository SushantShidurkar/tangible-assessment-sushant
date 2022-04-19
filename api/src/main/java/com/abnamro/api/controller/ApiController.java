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

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ApiController{

Logger logger= LoggerFactory.getLogger(RecipeController.class);
@Autowired
    private PersonService personService;

    @PostMapping("/person")  
	public ResponseEntity<String> createRecipe(@RequestBody Person person)  
	{  
		logger.info("createPerson called.");
		if(null==person) {
			recipeService.createRecipe(recipeDTO);  
			return new ResponseEntity<>(HttpStatus.OK); 
		}else {
			logger.error("Id found in create recipe.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
}