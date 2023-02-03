package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.AccountEntity;


public interface PersonService {
	List<PersonDto> getAllPersons();
	
	void savePerson(PersonDto dto);
	
	void deletePersonById(long id);
	
	AccountEntity saveAccount(AccountDto dto);

}