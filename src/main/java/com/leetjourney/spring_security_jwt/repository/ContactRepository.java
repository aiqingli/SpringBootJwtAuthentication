package com.leetjourney.spring_security_jwt.repository;

import com.leetjourney.spring_security_jwt.entity.Contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {    
    Contact findByEmail(String email);   

    @Override
    List<Contact> findAll();
}
