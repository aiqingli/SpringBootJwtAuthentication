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
     
    // Changed 'name' to 'fullName' to match the HTML form
    private String fullName; 

    @Column(unique = true)
    private String email;    

    private String phone;
    
    // Changed 'message' to 'projectSummary' to match the HTML form input name
    private String projectSummary; 

    // Custom toString for debugging (Jackson does NOT use this for JSON output)
    @Override
    public String toString() {
        return "Contact(id=" + this.id + 
               ", fullName=" + this.fullName + 
               ", email=" + this.email + 
               ", phone=" + this.phone + 
               ", projectSummary=" + this.projectSummary + ")";
    }
}
