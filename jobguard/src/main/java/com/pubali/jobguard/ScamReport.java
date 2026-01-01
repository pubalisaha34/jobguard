package com.pubali.jobguard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ScamReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scammerEmail; // e.g., "fake-hr@gmail.com"
    private String reportedBy;   // The user who caught them
    private LocalDateTime timestamp = LocalDateTime.now();

    public ScamReport(String email) {
        this.scammerEmail = email;
        this.reportedBy = "Anonymous Vigilante";
    }
}