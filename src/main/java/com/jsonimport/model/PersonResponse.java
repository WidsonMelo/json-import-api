package com.jsonimport.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PersonResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Person> persons;	

}
