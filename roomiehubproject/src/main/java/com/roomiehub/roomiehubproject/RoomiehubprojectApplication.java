package com.roomiehub.roomiehubproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RoomiehubprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomiehubprojectApplication.class, args);
    }
}
