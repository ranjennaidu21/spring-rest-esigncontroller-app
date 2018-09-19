package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class DisplayUserSetMemberInfos
{
    private String fullName;
    private String email;
    private String company;
    
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "DisplayUserSetMemberInfos [fullName=" + fullName + ", email=" + email + ", company=" + company + "]";
	}

}
