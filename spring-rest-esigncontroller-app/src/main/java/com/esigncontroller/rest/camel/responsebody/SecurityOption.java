package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class SecurityOption
{
    private String authenticationMethod;

	public String getAuthenticationMethod() {
		return authenticationMethod;
	}

	public void setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
	}

	@Override
	public String toString() {
		return "SecurityOption [authenticationMethod=" + authenticationMethod + "]";
	}
}
