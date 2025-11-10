package com.leetjourney.spring_security_jwt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leetjourney.spring_security_jwt.entity.Contact;
import com.leetjourney.spring_security_jwt.service.ContactService;


@RestController
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    private ContactService contactService;

    public  MainController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/welcome")
    public String allAccess() {
        return "Everyone access";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "User Content with JWT";
    }

   /**
     * Saves a new contact submission, returning a String message and appropriate HTTP status.
     * Returns 201 Created on success, or 400 Bad Request if the email is a duplicate.
     */
    @PostMapping("/contactus")
    public ResponseEntity<String> saveContact(@RequestBody Contact contact) {  
        // 1. Attempt to save the contact (returns null if duplicate)
        Contact savedContact = contactService.saveContact(contact);
        
        // 2. Check the result from the service
        if (savedContact == null) {
            // Duplicate found (service returned null)
            String message = "Contact with email " + contact.getEmail() + " already exists.";
            // Return 400 Bad Request with the desired error message
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            // Success
            String message = "Thank you for contacting us! We will get back to you soon.";
            // Return 201 Created status with the success message
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
    }
/**
     * Retrieves a contact by email.
     * Changes:
     * 1. Return type changed from String to ResponseEntity<Contact>.
     * 2. Uses service method to find contact.
     * 3. Returns 200 OK if found (Spring converts Contact object to JSON).
     * 4. Returns 404 NOT FOUND if contactService.findByEmail returns null.
     */
    @PostMapping("/getContact")
    public ResponseEntity<Contact> getContact(@RequestBody Contact contact) {  
        // Assuming findByEmail returns null if not found
        Contact foundContact = contactService.findByEmail(contact.getEmail());

        if (foundContact != null) {
            // Return 200 OK and the Contact object (serialized as JSON)
            return ResponseEntity.ok(foundContact);
        } else {
            // Return 404 NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }
}
