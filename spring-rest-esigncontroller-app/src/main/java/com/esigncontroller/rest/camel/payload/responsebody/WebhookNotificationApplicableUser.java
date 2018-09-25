
package com.esigncontroller.rest.camel.payload.responsebody;

import org.apache.commons.lang.builder.ToStringBuilder;

public class WebhookNotificationApplicableUser {

    private String id;
    private String email;
    private String role;
    private Boolean payloadApplicable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getPayloadApplicable() {
        return payloadApplicable;
    }

    public void setPayloadApplicable(Boolean payloadApplicable) {
        this.payloadApplicable = payloadApplicable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("email", email).append("role", role).append("payloadApplicable", payloadApplicable).toString();
    }

}
