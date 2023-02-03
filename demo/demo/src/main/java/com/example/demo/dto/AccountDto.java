package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;
    
    private String password;

    private Long personAccount;
}
