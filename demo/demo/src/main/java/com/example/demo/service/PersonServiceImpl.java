package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.EmailEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.EmailRepository;
import com.example.demo.repository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService, EmailService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private EmailRepository emailRepository;

	@Override
	// nella firma del metodo PersonDto al posto di PersonEntity
	public List<PersonEntity> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
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
    }

	@Override
	public void deletePersonById(long id) {
		this.personRepository.deleteById(id);
	}
	
	@Override
	public void saveEmail(EmailEntity email) {
		this.emailRepository.save(email);
	}

}