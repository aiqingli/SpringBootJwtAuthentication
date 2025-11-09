package com.leetjourney.spring_security_jwt.controller;



import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/contactus")
    public String saveContact(@RequestBody Contact contact) {  
        return contactService.saveContact(contact);   
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
