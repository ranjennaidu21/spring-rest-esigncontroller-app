package com.esigncontroller.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import com.esigncontroller.rest.weather.properties.WeatherAppProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
@EnableCaching(proxyTargetClass = true)
public class DemoAppConfig{

	public static void main(String[] args) {
        SpringApplication.run(DemoAppConfig.class, args);
    }
}








