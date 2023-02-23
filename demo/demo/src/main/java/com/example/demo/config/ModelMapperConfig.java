package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

import org.modelmapper.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.EmailEntity;
import com.example.demo.entity.PersonEntity;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {

		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(PersonEntity.class, PersonDto.class).addMapping(PersonEntity::getId, PersonDto::setId)
				.addMapping(PersonEntity::getName, PersonDto::setName)
				.addMapping(PersonEntity::getSurname, PersonDto::setSurname)
				.addMapping(PersonEntity::getPhone, PersonDto::setPhone)
				.addMapping(PersonEntity::getEmails, PersonDto::setEmails);

		modelMapper.createTypeMap(EmailEntity.class, EmailDto.class).addMapping(source -> source.getPerson().getId(),
				EmailDto::setPerson);

		return modelMapper;

	}

//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
//
//	public void sourceDestinationMapping(ModelMapper modelMapper) {
//		PropertyMap<PersonEntity, PersonDto> converter = new PropertyMap<>() {
//
//			@Override
//			protected void configure() {
//				map().setId(source.getId());
//				map().setName(source.getName());
//				map().setSurname(source.getSurname());
//				map().setPhone(source.getPhone());
//				map().getEmails();
//			}
//		};
//
//		modelMapper.addMappings(converter);
//
//	}
	
}
