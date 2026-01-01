package com.pubali.jobguard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class JobguardApplicationTests {

    @Autowired
    private SecurityController controller;

    @Test
    void contextLoads() {
        System.out.println("🧪 TEST STARTED");
        Assertions.assertNotNull(controller);
        System.out.println("✅ TEST PASSED");
    }
}
