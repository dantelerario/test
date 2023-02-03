package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.PersonDto;

@SpringBootTest
public class PersonServiceTest {
	
	@Mock
	PersonService personService;
	
	@Test
	public void whenGetAllPersonsthenReturnList() {
		List<PersonDto> persons = new ArrayList<PersonDto>();
		List<EmailDto> emails = new ArrayList<EmailDto>();
		persons.add(new PersonDto());
		persons.add(new PersonDto());
		Mockito.when(personService.getAllPersons()).thenReturn(persons);
		
		List<PersonDto> result = personService.getAllPersons();
		
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals(1L, result.get(0).getId());
		assertEquals("John", result.get(0).getName());
		assertEquals("Smith", result.get(0).getSurname());
		assertEquals(2L, result.get(1).getId());
		assertEquals("Jane", result.get(1).getName());
		assertEquals("Doe", result.get(1).getSurname());
	}
	
	@Test
	public void whenSavePersonthenDoNothing() {
		PersonDto personDto = new PersonDto();
		personService.savePerson(personDto);
		Mockito.verify(personService, Mockito.times(1)).savePerson(personDto);
	}
	
	@Test
	public void whenDeletePersonByIdthenDoNothing() {
		personService.deletePersonById(1L);
		Mockito.verify(personService, Mockito.times(1)).deletePersonById(1L);
	}
}