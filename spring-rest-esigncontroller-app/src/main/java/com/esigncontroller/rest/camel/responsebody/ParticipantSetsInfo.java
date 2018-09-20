package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class ParticipantSetsInfo
{
	private List<MemberInfos> memberInfos;
    private String role;
    private String order;
    
	public List<MemberInfos> getMemberInfos() {
		return memberInfos;
	}
	public void setMemberInfos(List<MemberInfos> memberInfos) {
		this.memberInfos = memberInfos;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "ParticipantSetsInfo [memberInfos=" + memberInfos + ", role=" + role + ", order=" + order + "]";
	}
	
	

    
}
