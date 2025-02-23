package com.diysolutions.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.diysolutions")
@EntityScan(basePackages = "com.diysolutions.entity")  // Explicitly scan entity package
@EnableJpaRepositories(basePackages = "com.diysolutions.repositories")  // Ensure repositories are scanned

public class OrderManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }

}
