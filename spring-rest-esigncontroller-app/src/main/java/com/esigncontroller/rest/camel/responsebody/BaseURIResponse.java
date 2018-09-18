package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class BaseURIResponse
{
    private String api_access_point;
    private String web_access_point;
    
	public String getApi_access_point() {
		return api_access_point;
	}
	public void setApi_access_point(String api_access_point) {
		this.api_access_point = api_access_point;
	}
	public String getWeb_access_point() {
		return web_access_point;
	}
	public void setWeb_access_point(String web_access_point) {
		this.web_access_point = web_access_point;
	}
	@Override
	public String toString() {
		return "BaseURIResponse [api_access_point=" + api_access_point + ", web_access_point=" + web_access_point + "]";
	}

}
