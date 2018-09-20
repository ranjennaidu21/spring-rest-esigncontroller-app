package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class MemberInfos
{
    private String email;
    private SecurityOption securityOption;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SecurityOption getSecurityOption() {
		return securityOption;
	}
	public void setSecurityOption(SecurityOption securityOption) {
		this.securityOption = securityOption;
	}
	@Override
	public String toString() {
		return "MemberInfos [email=" + email + ", securityOption=" + securityOption + "]";
	}

}
