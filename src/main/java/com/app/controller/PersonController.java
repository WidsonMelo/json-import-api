package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Person;
import com.app.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;	
	
	@GetMapping(value = "/persons")
	public ResponseEntity<List<Person>> findPersons(){		
		return ResponseEntity.ok(personService.getPersons());		
	}
		
	@GetMapping(value = "/persons/{personId}")
	public ResponseEntity<Person> findPersonById(@PathVariable("personId") Long id){		
		return ResponseEntity.ok(personService.getPersonById(id));		
	}
	
}
