
package com.esigncontroller.rest.camel.payload.responsebody;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ParticipantSet {

    private List<MemberInfo> memberInfos = null;
    private Integer order;
    private String role;
    private String status;
    private String id;

    public List<MemberInfo> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(List<MemberInfo> memberInfos) {
        this.memberInfos = memberInfos;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("memberInfos", memberInfos).append("order", order).append("role", role).append("status", status).append("id", id).toString();
    }

}
