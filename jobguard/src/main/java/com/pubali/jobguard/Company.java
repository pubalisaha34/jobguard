package com.pubali.jobguard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // CONCEPT: "Hey Database, create a table for this!"
@Data   // CONCEPT: "Hey Lombok, write the getters/setters for me!"
@NoArgsConstructor
public class Company {
    
    @Id // CONCEPT: "This is the unique ID (Primary Key)"
    private String companyName;    
    private String officialDomain; 

    public Company(String name, String domain) {
        this.companyName = name;
        this.officialDomain = domain;
    }
}