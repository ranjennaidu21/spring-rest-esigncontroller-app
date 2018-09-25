
package com.esigncontroller.rest.camel.payload.responsebody;

import org.apache.commons.lang.builder.ToStringBuilder;

public class MemberInfo {

    private String id;
    private String email;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("email", email).toString();
    }

}
