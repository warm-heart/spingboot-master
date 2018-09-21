package com.term.design;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
    }
}
