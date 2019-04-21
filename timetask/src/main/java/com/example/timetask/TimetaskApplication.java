package com.example.timetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimetaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimetaskApplication.class, args);
    }

}
