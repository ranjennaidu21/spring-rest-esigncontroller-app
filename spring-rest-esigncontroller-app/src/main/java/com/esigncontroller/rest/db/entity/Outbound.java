package com.esigncontroller.rest.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="outbound")
public class Outbound {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="agreemendid")
	private String agreementId;
	
	@Column(name="referenceno")
	private String referenceNo;
	
	@Column(name="accesstoken")
	private String accessToken;
	
	@Column(name="outboundstatus")
	private String outboundStatus;

	
	public Outbound() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAgreementId() {
		return agreementId;
	}


	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}


	public String getReferenceNo() {
		return referenceNo;
	}


	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getOutboundStatus() {
		return outboundStatus;
	}


	public void setOutboundStatus(String outboundStatus) {
		this.outboundStatus = outboundStatus;
	}


	@Override
	public String toString() {
		return "Outbound [id=" + id + ", agreementId=" + agreementId + ", referenceNo=" + referenceNo + ", accessToken="
				+ accessToken + ", outboundStatus=" + outboundStatus + "]";
	}
	
}





