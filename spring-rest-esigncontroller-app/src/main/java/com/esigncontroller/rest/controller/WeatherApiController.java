package com.esigncontroller.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esigncontroller.rest.entity.Weather;
import com.esigncontroller.rest.services.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

	@Autowired
	WeatherService weatherService;
	
	//test by sending REST request to 
	//eg:http://localhost:8080/api/weather/now/London/US
	//eg:http://localhost:8080/api/weather/now/London/UK
	//eg:http://localhost:8080/api/weather/now/Moscow/Russia
	@GetMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable String country,
			@PathVariable String city) {
		return this.weatherService.getWeather(country, city);
	}

}
