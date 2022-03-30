package com.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Person;
import com.app.model.PersonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {
	
	@Autowired
	protected ObjectMapper objectMapper;	
	
	public List<Person> getPersons(){
		List<Person> persons = getPersonFromJson();				
		return persons;		
	}
	
	public Person getPersonById(Long id) {
		List<Person> persons = getPersonFromJson();				
		return persons.stream().filter(p -> p.getId().equals(id)).findAny().get();		
	}
	
	private List<Person> getPersonFromJson() {		
		InputStream stream = PersonResponse.class.getResourceAsStream("/json/bd.json");		
		try {
			log.info("Importing Json from /json/bd.json");
			PersonResponse personList = objectMapper.readValue(stream, PersonResponse.class);
			log.info("Json imported done: {}", personList);
			return personList.getPersons();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}	

}
