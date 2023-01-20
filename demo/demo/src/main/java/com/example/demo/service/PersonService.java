package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.PersonDto;


public interface PersonService {
	List<PersonDto> getAllPersons();
	
	void savePerson(PersonDto dto);
	
	void deletePersonById(long id);

}