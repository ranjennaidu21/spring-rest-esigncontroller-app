package com.esigncontroller.rest.camel.responsebody;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class WeatherResponse {

	private String name;
	
	private Instant timestamp;

	private double temperature;

	private Integer weatherId;

	private String weatherIcon;

    public WeatherResponse() {
    }
    
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Instant getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
	}

	/**
	 * Return the temperature in Kelvin (K).
	 */
	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setMain(Map<String, Object> main) {
		setTemperature(Double.parseDouble(main.get("temp").toString()));
	}

	public Integer getWeatherId() {
		return this.weatherId;
	}

	public void setWeatherId(Integer weatherId) {
		this.weatherId = weatherId;
	}

	public String getWeatherIcon() {
		return this.weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherId((Integer) weather.get("id"));
		setWeatherIcon((String) weather.get("icon"));
	}


}
