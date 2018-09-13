package com.esigncontroller.rest.camel.requestbody;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class WeatherRequest {
    
	private String city;
    private String country;
    private String key;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "WeatherRequest [city=" + city + ", country=" + country + ", key=" + key + "]";
	}

	


}
