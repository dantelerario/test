package com.example.demo.dto;

import com.example.demo.entity.EmailEntity;
import com.example.demo.entity.PersonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavePersonInputDto {
	private PersonEntity personEntity; 
	private EmailEntity emailEntity; 
}
