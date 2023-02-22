package com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.EmailDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.EmailEntity;
import com.example.demo.entity.PersonEntity;

public class Converter {
	
	public static PersonDto toDto(PersonEntity personEntity) {
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
//		personDto.getAccount().setUsername(personEntity.getAccount().getUsername());
//		personDto.getAccount().setPassword(personEntity.getAccount().getPassword());
		personDto.setEmails(personEntity.getEmails().stream()
				.map(emailEntity -> {
				    EmailDto emailDto = new EmailDto();
				    emailDto.setEmail(emailEntity.getEmail());
				    return emailDto;
				})
				.collect(Collectors.toList()));
		return personDto;
	}
	
	public static EmailDto toDto(EmailEntity entity) {
        EmailDto dto = new EmailDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPerson(entity.getPerson().getId());
        return dto;
    }

    public static EmailEntity toEntity(EmailDto dto) {
        EmailEntity entity = new EmailEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public static List<EmailDto> toDtoList(List<EmailEntity> entities) {
        return entities.stream()
                       .map(Converter::toDto)
                       .collect(Collectors.toList());
    }

    public static List<EmailEntity> toEntityList(List<EmailDto> dtos) {
        return dtos.stream()
                   .map(Converter::toEntity)
                   .collect(Collectors.toList());
    }
    
	public static AccountDto toDto(AccountEntity entity) {
		AccountDto dto = new AccountDto();
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		return dto;
	}
	
}
