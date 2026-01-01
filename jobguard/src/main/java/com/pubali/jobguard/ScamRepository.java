package com.pubali.jobguard;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScamRepository extends JpaRepository<ScamReport, Long> {
    // A spell to get the 5 most recent scams to show on the dashboard
    List<ScamReport> findTop5ByOrderByTimestampDesc();
}