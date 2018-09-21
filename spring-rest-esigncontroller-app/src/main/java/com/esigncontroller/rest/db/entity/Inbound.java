package com.esigncontroller.rest.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inbound")
public class Inbound {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="agreementid")
	private String agreementId;
	
	@Column(name="targetdir")
	private String targetDir;
	
	@Column(name="inboundstatus")
	private String inboundStatus;
	
	@Column(name="documentid")
	private String documentId;

	
	public Inbound() {
		
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


	public String getTargetDir() {
		return targetDir;
	}


	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}


	public String getInboundStatus() {
		return inboundStatus;
	}


	public void setInboundStatus(String inboundStatus) {
		this.inboundStatus = inboundStatus;
	}


	public String getDocumentId() {
		return documentId;
	}


	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}


	@Override
	public String toString() {
		return "Inbound [id=" + id + ", agreementId=" + agreementId + ", targetDir=" + targetDir + ", inboundStatus="
				+ inboundStatus + ", documentId=" + documentId + "]";
	}


	
}





