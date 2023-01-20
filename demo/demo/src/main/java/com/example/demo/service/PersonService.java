package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.PersonEntity;


public interface PersonService {
	List<PersonEntity> getAllPersons();
	
	void savePerson(PersonDto dto);
	
	void deletePersonById(long id);

}