package com.leetjourney.spring_security_jwt.service;

import com.leetjourney.spring_security_jwt.entity.Contact;
import com.leetjourney.spring_security_jwt.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    private Contact testContact;

    @BeforeEach
    void setUp() {
        testContact = new Contact();
        testContact.setId(1L);
        testContact.setEmail("test@example.com");
        testContact.setName("Test User");
    }

    @Test
    void testFindContactByEmail_Success() {
        when(contactRepository.findByEmail("test@example.com")).thenReturn(testContact);

        Contact result = contactService.findByEmail("test@example.com");

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        assertEquals(1L, result.getId());
    }

    @Test
    void testFindContactByEmail_NotFound() {
        when(contactRepository.findByEmail("nonexistent@example.com")).thenReturn(null);

        Contact result = contactService.findByEmail("nonexistent@example.com");

        assertNull(result);
    }

    @Test
    void testSaveContact_Success() {
        when(contactRepository.save(testContact)).thenReturn(testContact);

        String result = contactService.saveContact(testContact);

        assertEquals("Thank you for contacting us! Your contact ID is: 1", result);
    }
}