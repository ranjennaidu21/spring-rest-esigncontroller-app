package com.esigncontroller.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.esigncontroller.rest.controller.CustomerRestController;

@SpringBootApplication
public class DemoAppConfig{

	public static void main(String[] args) {
        SpringApplication.run(DemoAppConfig.class, args);
    }
}








