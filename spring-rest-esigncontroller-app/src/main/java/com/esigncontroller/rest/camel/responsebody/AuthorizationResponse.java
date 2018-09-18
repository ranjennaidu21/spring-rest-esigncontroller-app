package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class AuthorizationResponse
{
    private String code;
    private String state;
    private String api_access_point;
    private String web_access_point;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
		return "AuthorizationResponse [code=" + code + ", state=" + state + ", api_access_point=" + api_access_point
				+ ", web_access_point=" + web_access_point + "]";
	}

	
	



}
