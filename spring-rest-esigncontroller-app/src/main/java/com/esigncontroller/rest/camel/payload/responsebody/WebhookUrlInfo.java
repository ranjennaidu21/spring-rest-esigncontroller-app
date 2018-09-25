
package com.esigncontroller.rest.camel.payload.responsebody;

import org.apache.commons.lang.builder.ToStringBuilder;

public class WebhookUrlInfo {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).toString();
    }

}
