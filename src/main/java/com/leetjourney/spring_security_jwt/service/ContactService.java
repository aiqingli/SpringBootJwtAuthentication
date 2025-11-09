package com.leetjourney.spring_security_jwt.service;
import com.leetjourney.spring_security_jwt.entity.Contact;
import com.leetjourney.spring_security_jwt.repository.ContactRepository;

import org.springframework.stereotype.Service;

@Service
public class ContactService  {

    private ContactRepository contactRepository;
    
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public Contact findByEmail(String email) {
        Contact contact = contactRepository.findByEmail(email);       
        return contact;
    }

    public String saveContact(Contact contact) {
        Contact existingContact = contactRepository.findByEmail(contact.getEmail());
        if (existingContact != null) {
            return "Contact with email " + contact.getEmail() + " already exists.";
        }
        Contact savedContact = contactRepository.save(contact);       
        return "Thank you for contacting us! Your contact ID is: " + savedContact.getId();        
    }          
}
