package com.esigncontroller.rest.weather.entity;

public class Weather extends WeatherEntry {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
