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
    
    /**
     * Saves a new contact submission.
     * NOTE: Updated to return the saved Contact object instead of a String message.
     * @param contact The Contact entity to save.
     * @return The persisted Contact entity.
     * @throws RuntimeException if a contact with the same email already exists.
     */
    public Contact saveContact(Contact contact) {
        // Check if a contact with this email already exists
        Contact existingContact = contactRepository.findByEmail(contact.getEmail());
        
        if (existingContact != null) {
            return null; 
        }
        
        // Save the new contact and return the saved object
        Contact savedContact = contactRepository.save(contact);       
        return savedContact;        
    }      
}
