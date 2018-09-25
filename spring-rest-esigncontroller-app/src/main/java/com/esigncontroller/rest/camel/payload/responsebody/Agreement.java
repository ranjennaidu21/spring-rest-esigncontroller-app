
package com.esigncontroller.rest.camel.payload.responsebody;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Agreement {

    private String id;
    private String name;
    private String signatureType;
    private String status;
    private Boolean documentVisibilityEnabled;
    private String createdDate;
    private String locale;
    private String message;
    private String senderEmail;
    private ParticipantSetsInfo participantSetsInfo;

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

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDocumentVisibilityEnabled() {
        return documentVisibilityEnabled;
    }

    public void setDocumentVisibilityEnabled(Boolean documentVisibilityEnabled) {
        this.documentVisibilityEnabled = documentVisibilityEnabled;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public ParticipantSetsInfo getParticipantSetsInfo() {
        return participantSetsInfo;
    }

    public void setParticipantSetsInfo(ParticipantSetsInfo participantSetsInfo) {
        this.participantSetsInfo = participantSetsInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("signatureType", signatureType).append("status", status).append("documentVisibilityEnabled", documentVisibilityEnabled).append("createdDate", createdDate).append("locale", locale).append("message", message).append("senderEmail", senderEmail).append("participantSetsInfo", participantSetsInfo).toString();
    }

}
