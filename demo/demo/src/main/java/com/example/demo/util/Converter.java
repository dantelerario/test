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
	public static PersonDto toDto(PersonEntity entity) {
		PersonDto dto = new PersonDto();
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setPhone(entity.getPhone());
		dto.setEmails(toDtoList(entity.getEmails()));
		return dto;
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
