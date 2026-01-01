package com.pubali.jobguard;

import org.springframework.data.jpa.repository.JpaRepository;

// TEACHING MOMENT: 
// "extends JpaRepository" is the magic. 
// It automatically gives us methods like .save(), .delete(), and .findAll().
public interface CompanyRepository extends JpaRepository<Company, String> {
    
    // We define this method signature, and Spring Boot implements the logic for us!
    // It knows to look at the "companyName" field in the Company class.
    Company findByCompanyName(String companyName);
}