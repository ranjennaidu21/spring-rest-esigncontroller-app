package com.esigncontroller.rest.camel.responsebody;

import lombok.Data;

@Data
public class TransientDocumentResponse
{
    private String transientDocumentId;

	public String getTransientDocumentId() {
		return transientDocumentId;
	}

	public void setTransientDocumentId(String transientDocumentId) {
		this.transientDocumentId = transientDocumentId;
	}

	@Override
	public String toString() {
		return "TransientDocumentResponse [transientDocumentId=" + transientDocumentId + "]";
	}

}
