package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/test")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getAllPersons")
	public ResponseEntity<List<PersonDto>> getAllPersons() {
		try {
			// get list of all persons
			List<PersonDto> persons = personService.getAllPersons();
			return new ResponseEntity<>(persons, HttpStatus.OK);
		} catch (Exception e) {
			// handle the exception
			e.printStackTrace();
	        throw e;
		}
	}

	@PostMapping("/savePerson")
	public ResponseEntity<String> savePerson(@RequestBody PersonDto person) {

		// save person to database
		personService.savePerson(person);
		return new ResponseEntity<String>("person saved", HttpStatus.OK);
	}

	@GetMapping("/deletePerson/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable(value = "id") long id) {

		// call delete person method
		this.personService.deletePersonById(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@PostMapping("/saveAccount")
	public ResponseEntity<String> saveAccount(@RequestBody AccountDto account) {

		// save account to database
		personService.saveAccount(account);
		return new ResponseEntity<String>("account saved", HttpStatus.OK);
	}
}
