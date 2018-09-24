package com.esigncontroller.rest.camel.services;

import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.esigncontroller.rest.camel.responsebody.BaseURIResponse;
import com.esigncontroller.rest.camel.util.GlobalConstants;

@RestController
public class BaseUriService {
	
    @Produce
    private ProducerTemplate template;
    
    private static final Logger logger = LoggerFactory.getLogger(BaseUriService.class);

    public final static String URL = "https://secure.na2.echosign.com/api/rest/v6/baseUris";
    
	@Value("${api.integration.key}")
	private String IntegrationKey;
    
    @GetMapping("/base_uris")
	public String getBaseURI() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", IntegrationKey);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<BaseURIResponse> response = restTemplate.exchange(URL, HttpMethod.GET, entity, BaseURIResponse.class);        
        System.out.println(response.getBody());
		logger.info(response.getBody().toString());
	    String apiAccessPoint = (String) response.getBody().getApiAccessPoint();
	    logger.info("Base URI : " + apiAccessPoint);
	    return apiAccessPoint;
	}

}
