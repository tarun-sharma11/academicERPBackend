package com.example.academicerpbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AcademicErpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademicErpBackendApplication.class, args);
    }

}
