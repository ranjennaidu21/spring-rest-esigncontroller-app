package com.esigncontroller.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoAppConfig{

	public static void main(String[] args) {
        SpringApplication.run(DemoAppConfig.class, args);
    }
}








