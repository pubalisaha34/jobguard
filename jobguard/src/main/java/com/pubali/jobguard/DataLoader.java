package com.pubali.jobguard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component // <--- This tells Spring: "Run this class automatically when the app starts"
public class DataLoader implements CommandLineRunner {

    private final CompanyRepository repo;

    // We ask Spring to give us the Repository tool we created in Phase 4
    public DataLoader(CompanyRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Find the "trusted_companies.csv" file in the resources folder
        var file = getClass().getResourceAsStream("/trusted_companies.csv");
        
        // 2. Open a reader to scan the text line-by-line
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        
        String line;
        reader.readLine(); // <--- CRITICAL: We skip the first line because it's just headers ("companyName,officialDomain")
        
        // 3. Loop through the rest of the file
        while ((line = reader.readLine()) != null) {
            // line looks like: "Oracle,oracle.com"
            String[] data = line.split(","); 
            
            // data[0] is "Oracle", data[1] is "oracle.com"
            // We create a new Company object and save it to the DB
            repo.save(new Company(data[0], data[1]));
        }
        System.out.println("✅ SECURITY DB LOADED: Trusted domains are active.");
    }
}