
package com.esigncontroller.rest.camel.payload.responsebody;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AgreementPayloadResponse {

    private String webhookId;
    private String webhookName;
    private String webhookNotificationId;
    private WebhookUrlInfo webhookUrlInfo;
    private String webhookScope;
    private List<WebhookNotificationApplicableUser> webhookNotificationApplicableUsers = null;
    private String event;
    private String eventDate;
    private String eventResourceType;
    private String participantUserId;
    private String participantUserEmail;
    private String actingUserId;
    private String actingUserEmail;
    private String actingUserIpAddress;
    private Agreement agreement;

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(String webhookId) {
        this.webhookId = webhookId;
    }

    public String getWebhookName() {
        return webhookName;
    }

    public void setWebhookName(String webhookName) {
        this.webhookName = webhookName;
    }

    public String getWebhookNotificationId() {
        return webhookNotificationId;
    }

    public void setWebhookNotificationId(String webhookNotificationId) {
        this.webhookNotificationId = webhookNotificationId;
    }

    public WebhookUrlInfo getWebhookUrlInfo() {
        return webhookUrlInfo;
    }

    public void setWebhookUrlInfo(WebhookUrlInfo webhookUrlInfo) {
        this.webhookUrlInfo = webhookUrlInfo;
    }

    public String getWebhookScope() {
        return webhookScope;
    }

    public void setWebhookScope(String webhookScope) {
        this.webhookScope = webhookScope;
    }

    public List<WebhookNotificationApplicableUser> getWebhookNotificationApplicableUsers() {
        return webhookNotificationApplicableUsers;
    }

    public void setWebhookNotificationApplicableUsers(List<WebhookNotificationApplicableUser> webhookNotificationApplicableUsers) {
        this.webhookNotificationApplicableUsers = webhookNotificationApplicableUsers;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventResourceType() {
        return eventResourceType;
    }

    public void setEventResourceType(String eventResourceType) {
        this.eventResourceType = eventResourceType;
    }

    public String getParticipantUserId() {
        return participantUserId;
    }

    public void setParticipantUserId(String participantUserId) {
        this.participantUserId = participantUserId;
    }

    public String getParticipantUserEmail() {
        return participantUserEmail;
    }

    public void setParticipantUserEmail(String participantUserEmail) {
        this.participantUserEmail = participantUserEmail;
    }

    public String getActingUserId() {
        return actingUserId;
    }

    public void setActingUserId(String actingUserId) {
        this.actingUserId = actingUserId;
    }

    public String getActingUserEmail() {
        return actingUserEmail;
    }

    public void setActingUserEmail(String actingUserEmail) {
        this.actingUserEmail = actingUserEmail;
    }

    public String getActingUserIpAddress() {
        return actingUserIpAddress;
    }

    public void setActingUserIpAddress(String actingUserIpAddress) {
        this.actingUserIpAddress = actingUserIpAddress;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("webhookId", webhookId).append("webhookName", webhookName).append("webhookNotificationId", webhookNotificationId).append("webhookUrlInfo", webhookUrlInfo).append("webhookScope", webhookScope).append("webhookNotificationApplicableUsers", webhookNotificationApplicableUsers).append("event", event).append("eventDate", eventDate).append("eventResourceType", eventResourceType).append("participantUserId", participantUserId).append("participantUserEmail", participantUserEmail).append("actingUserId", actingUserId).append("actingUserEmail", actingUserEmail).append("actingUserIpAddress", actingUserIpAddress).append("agreement", agreement).toString();
    }

}
