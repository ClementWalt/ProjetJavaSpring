package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ContactApplication {

    private static final Logger log = LoggerFactory.getLogger(ContactApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }


}