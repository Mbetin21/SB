/**
 * This file is the main entry point of the Spring Boot application.
 * It initializes the Spring context and starts the embedded server.
 * 
 * Author: Mariam Betin <mbetine@udistrital.edu.co>
 */
package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
