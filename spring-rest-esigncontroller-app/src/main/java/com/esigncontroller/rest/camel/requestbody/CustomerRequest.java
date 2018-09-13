package com.esigncontroller.rest.camel.requestbody;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class CustomerRequest {
    
	private String firstName;
    private String lastName;
    private String email;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	

}
