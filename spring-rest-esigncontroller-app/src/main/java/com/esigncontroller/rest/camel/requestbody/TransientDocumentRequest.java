package com.esigncontroller.rest.camel.requestbody;

import lombok.Data;

@Data
public class TransientDocumentRequest
{		
    private String fileName;
    private String mimeType;
    private String fileToBeUploaded;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getFileToBeUploaded() {
		return fileToBeUploaded;
	}
	public void setFileToBeUploaded(String fileToBeUploaded) {
		this.fileToBeUploaded = fileToBeUploaded;
	}
	@Override
	public String toString() {
		return "TransientDocumentRequest [fileName=" + fileName + ", mimeType=" + mimeType + ", fileToBeUploaded="
				+ fileToBeUploaded + "]";
	}

}
