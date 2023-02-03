package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.EmailDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.EmailEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<PersonDto> getAllPersons() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return personEntities.stream().map(personEntity -> {
			PersonDto personDto = new PersonDto();
			personDto.setId(personEntity.getId());
			personDto.setName(personEntity.getName());
			personDto.setSurname(personEntity.getSurname());
			personDto.setPhone(personEntity.getPhone());
			personDto.setEmails(personEntity.getEmails().stream()
				.map(emailEntity -> {
				    EmailDto emailDto = new EmailDto();
				    emailDto.setEmail(emailEntity.getEmail());
				    return emailDto;
				})
				.collect(Collectors.toList()));
			return personDto;
		}).collect(Collectors.toList());
	}
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void savePerson(PersonDto personDto) {

        PersonEntity person = new PersonEntity();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setPhone(personDto.getPhone());

        List<EmailEntity> emails = personDto.getEmails().stream()
                .map(emailDto -> {
                    EmailEntity emailEntity = new EmailEntity();
                    emailEntity.setEmail(emailDto.getEmail());
                    emailEntity.setPerson(person);
                    return emailEntity;
                })
                .collect(Collectors.toList());

        person.setEmails(emails);

        this.personRepository.save(person);
//        throw new RuntimeException("test error transactional");
    } 

	@Override
	public void deletePersonById(long id) {
		this.personRepository.deleteById(id);
	}
	
	@Override
	public AccountEntity saveAccount(AccountDto dto) {
		
		AccountEntity account = new AccountEntity();
		account.setUsername(dto.getUsername());
		account.setPassword(dto.getPassword());
		
		return accountRepository.save(account);
		
	}

}