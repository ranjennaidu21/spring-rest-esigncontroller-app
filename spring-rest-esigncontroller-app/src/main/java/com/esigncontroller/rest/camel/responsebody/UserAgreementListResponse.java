package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class UserAgreementListResponse
{
 
	private List<UserAgreement> userAgreementList;

	public List<UserAgreement> getUserAgreementList() {
		return userAgreementList;
	}

	public void setUserAgreementList(List<UserAgreement> userAgreementList) {
		this.userAgreementList = userAgreementList;
	}

	@Override
	public String toString() {
		return "UserAgreementListResponse [userAgreementList=" + userAgreementList + "]";
	} 

}
