package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

//import com.example.demo.entity.EmailEntity;
//import com.example.demo.util.Converter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto implements Serializable {

	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String surname;

    private Long phone;

    private List<EmailDto> emails;
    
//    private AccountDto account;

}
