package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class UserAgreement
{
    private String id;
    private String displayDate;
    private List<DisplayParticipantSetInfos> displayParticipantSetInfos;
    private String latestVersionId;
    private String name;
    private String status;
    private String esign;
    private String hidden;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayDate() {
		return displayDate;
	}
	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public List<DisplayParticipantSetInfos> getDisplayParticipantSetInfos() {
		return displayParticipantSetInfos;
	}
	public void setDisplayParticipantSetInfos(List<DisplayParticipantSetInfos> displayParticipantSetInfos) {
		this.displayParticipantSetInfos = displayParticipantSetInfos;
	}
	public String getLatestVersionId() {
		return latestVersionId;
	}
	public void setLatestVersionId(String latestVersionId) {
		this.latestVersionId = latestVersionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEsign() {
		return esign;
	}
	public void setEsign(String esign) {
		this.esign = esign;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	@Override
	public String toString() {
		return "UserAgreement [id=" + id + ", displayDate=" + displayDate + ", displayParticipantSetInfos="
				+ displayParticipantSetInfos + ", latestVersionId=" + latestVersionId + ", name=" + name + ", status="
				+ status + ", esign=" + esign + ", hidden=" + hidden + "]";
	}

	

}
