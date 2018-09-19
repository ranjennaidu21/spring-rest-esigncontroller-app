package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class BaseURIResponse
{
    private String apiAccessPoint;
    private String webAccessPoint;
    
	public String getApiAccessPoint() {
		return apiAccessPoint;
	}
	public void setApiAccessPoint(String apiAccessPoint) {
		this.apiAccessPoint = apiAccessPoint;
	}
	public String getWebAccessPoint() {
		return webAccessPoint;
	}
	public void setWebAccessPoint(String webAccessPoint) {
		this.webAccessPoint = webAccessPoint;
	}
	@Override
	public String toString() {
		return "BaseURIResponse [apiAccessPoint=" + apiAccessPoint + ", webAccessPoint=" + webAccessPoint + "]";
	}
    
    

}
