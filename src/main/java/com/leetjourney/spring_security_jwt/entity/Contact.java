package com.leetjourney.spring_security_jwt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Provides getters, setters, toString, equals, hashCode
import lombok.NoArgsConstructor;

@Entity
@Data // Use Lombok to ensure all getters/setters are generated for JSON serialization
@NoArgsConstructor
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        
    
    private String name; 

    @Column(unique = true)
    private String email;    

    private String phone;
    
    // Changed 'message' to 'projectSummary' to match the HTML form input name
    private String message; 

    // Custom toString for debugging (Jackson does NOT use this for JSON output)
    @Override
    public String toString() {
        return "Contact(id=" + this.id + 
               ", name=" + this.name + 
               ", email=" + this.email + 
               ", phone=" + this.phone + 
               ", message=" + this.message + ")";
    }
}
