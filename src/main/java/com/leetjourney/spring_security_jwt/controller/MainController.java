package com.leetjourney.spring_security_jwt.controller;



import org.springframework.beans.factory.annotation.Autowired;
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
       // return "Thank you for contacting us!";       
    }

    @PostMapping("/getContact")
    public String getContact(@RequestBody Contact contact) {  
        contactService.findByEmail(contact.getEmail());  
        return "Thank you for contacting us! Your contact ID is: " + contact.getId();       
    }
}
