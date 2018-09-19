package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class DocumentListResponse
{
 
	private List<Document> documents;

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "DocumentListResponse [documents=" + documents + "]";
	}

}
