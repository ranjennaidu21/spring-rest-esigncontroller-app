package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class DisplayParticipantSetInfos
{
	private List<DisplayUserSetMemberInfos> displayUserSetMemberInfos;

	public List<DisplayUserSetMemberInfos> getDisplayUserSetMemberInfos() {
		return displayUserSetMemberInfos;
	}

	public void setDisplayUserSetMemberInfos(List<DisplayUserSetMemberInfos> displayUserSetMemberInfos) {
		this.displayUserSetMemberInfos = displayUserSetMemberInfos;
	}

	@Override
	public String toString() {
		return "DisplayParticipantSetInfos [displayUserSetMemberInfos=" + displayUserSetMemberInfos + "]";
	}

}
