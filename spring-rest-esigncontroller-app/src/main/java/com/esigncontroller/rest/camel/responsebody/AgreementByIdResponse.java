package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class AgreementByIdResponse
{
    private String id;
    private String name;
    private String message;
    private List<ParticipantSetsInfo> participantSetsInfo;
    private String senderEmail;
    private String createdDate;
    private String signatureType;
    private String locale;
    private String status;
    private String documentVisibilityEnabled;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ParticipantSetsInfo> getParticipantSetsInfo() {
		return participantSetsInfo;
	}
	public void setParticipantSetsInfo(List<ParticipantSetsInfo> participantSetsInfo) {
		this.participantSetsInfo = participantSetsInfo;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getSignatureType() {
		return signatureType;
	}
	public void setSignatureType(String signatureType) {
		this.signatureType = signatureType;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDocumentVisibilityEnabled() {
		return documentVisibilityEnabled;
	}
	public void setDocumentVisibilityEnabled(String documentVisibilityEnabled) {
		this.documentVisibilityEnabled = documentVisibilityEnabled;
	}
	@Override
	public String toString() {
		return "AgreementByIdResponse [id=" + id + ", name=" + name + ", message=" + message + ", participantSetsInfo="
				+ participantSetsInfo + ", senderEmail=" + senderEmail + ", createdDate=" + createdDate
				+ ", signatureType=" + signatureType + ", locale=" + locale + ", status=" + status
				+ ", documentVisibilityEnabled=" + documentVisibilityEnabled + "]";
	}

	

	
 
}
