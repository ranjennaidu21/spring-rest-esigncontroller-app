package com.esigncontroller.rest.camel.services;

import javax.validation.Valid;

import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esigncontroller.rest.camel.requestbody.WeatherRequest;
import com.esigncontroller.rest.camel.responsebody.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherApiService {
	
	//test by sending REST request to 
	//eg:https://localhost:8443/weather/London/US
	//eg:https://localhost:8443/weather/London/UK
	//eg:https://localhost:8443/weather/Moscow/Russia
	
    @Produce
    private ProducerTemplate template;

/*	private static final String WEATHER_URL =
			"http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";*/

	private static final Logger logger = LoggerFactory.getLogger(WeatherApiService.class);
	
	private final String apiKey = "3868674fd064becf6106a7a873eb24d9";
	
/*	JSON Body to send from POSTMAN
	{
	    "city": "LONDON",
	    "country": "UK"
	}
*/
	
	//@PostMapping(value="/{country}/{city}",headers = "Accept=application/json", produces = "application/json")
	@PostMapping(value="/post",headers = "Accept=application/json", produces = "application/json")
	public WeatherResponse getWeatherResponse(@Valid @RequestBody WeatherRequest weatherRequest) {
		System.out.println(weatherRequest);
		//SET THE KEY as for weather api each request need to incude with key
		weatherRequest.setKey(apiKey);
		WeatherRequest responsefromcamel = (WeatherRequest) template.sendBody("direct:weather", ExchangePattern.InOut, weatherRequest);
		RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+responsefromcamel.getCity()+","+responsefromcamel.getCountry()+"&APPID="+responsefromcamel.getKey()+"", WeatherResponse.class);
        logger.info(weatherResponse.toString());
		return weatherResponse;
		
	}

/*	Eg:Send POST method to this URL
	https://localhost:8443/weather/UK
*/	
	@PostMapping(value="/{country}",headers = "Accept=application/json", produces = "application/json")
	public WeatherResponse getWeatherResponseByCountry(@PathVariable String country) {
		System.out.println(country);
		//SET THE KEY as for weather api each request need to incude with key
		//weatherRequest.setKey(apiKey);
		String camelCountryResponse = (String) template.sendBody("direct:weather", ExchangePattern.InOut, country);
		//WeatherRequest responsefromcamel = (WeatherRequest) template.sendBody("direct:weather", ExchangePattern.InOut, weatherRequest);
		RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=LONDON,"+camelCountryResponse+"&APPID="+apiKey+"", WeatherResponse.class);
        logger.info(weatherResponse.toString());
		return weatherResponse;
		
	}
	
/*	Eg:Send POST method to this URL
	https://localhost:8443/weather/UK/LONDON
*/	
	@PostMapping(value="/{country}/{city}",headers = "Accept=application/json", produces = "application/json")
	public WeatherResponse getWeatherResponseByCountryAndCity(@PathVariable String country,@PathVariable String city) {
		WeatherRequest weatherRequest = new WeatherRequest();
		weatherRequest.setCountry(country);
		weatherRequest.setCity(city);
		//SET THE KEY as for weather api each request need to incude with key
		weatherRequest.setKey(apiKey);
		WeatherRequest camelCountryResponse = (WeatherRequest) template.sendBody("direct:weather", ExchangePattern.InOut, weatherRequest);
		RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+camelCountryResponse.getCity()+","+camelCountryResponse.getCountry()+"&APPID="+camelCountryResponse.getKey()+"", WeatherResponse.class);
        logger.info(weatherResponse.toString());
		return weatherResponse;
		
	}

}
