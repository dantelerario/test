package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmailEntity;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

}

