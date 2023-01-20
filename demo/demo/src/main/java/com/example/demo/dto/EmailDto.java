package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private Long person;
}
