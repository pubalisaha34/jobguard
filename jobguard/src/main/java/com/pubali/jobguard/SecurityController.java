package com.pubali.jobguard;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/security")
public class SecurityController {

    private final CompanyRepository companyRepo;
    private final ScamRepository scamRepo; // <--- Ensure this is here

    public SecurityController(CompanyRepository companyRepo, ScamRepository scamRepo) {
        this.companyRepo = companyRepo;
        this.scamRepo = scamRepo;
    }

    // 1. VERIFY
    @GetMapping("/verify")
    public String verifyRecruiter(@RequestParam String company, @RequestParam String email) {
        Company trusted = companyRepo.findByCompanyName(company);
        if (trusted == null) return "⚠️ Unknown Company";

        String emailDomain = email.substring(email.indexOf("@") + 1);

        if (emailDomain.equalsIgnoreCase(trusted.getOfficialDomain())) {
            return "✅ VERIFIED: Legit email from " + company;
        } else {
            return "❌ PHISHING ALERT: Domain mismatch!";
        }
    }

    // 2. REPORT (This is what gave you the 404 Error)
    @PostMapping("/report")
    public ScamReport reportScam(@RequestParam String email) {
        return scamRepo.save(new ScamReport(email));
    }

    // 3. RECENT (This also gave you a 404 Error)
    @GetMapping("/recent")
    public List<ScamReport> getRecentScams() {
        return scamRepo.findTop5ByOrderByTimestampDesc();
    }
}


