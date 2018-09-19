package com.esigncontroller.rest.camel.responsebody;

import java.util.List;

import lombok.Data;

@Data
public class Document
{
    private String id;
    private String name;
    private String mimeType;
    private String numPages;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getNumPages() {
		return numPages;
	}
	public void setNumPages(String numPages) {
		this.numPages = numPages;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", mimeType=" + mimeType + ", numPages=" + numPages + "]";
	}

}
