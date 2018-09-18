package com.esigncontroller.rest.camel.services;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.esigncontroller.rest.camel.responsebody.BaseURIResponse;

@RestController
public class BaseUriService {
	
    @Produce
    private ProducerTemplate template;
    
    private static final Logger logger = LoggerFactory.getLogger(BaseUriService.class);
    public final static String ACCESSTOKEN = "3AAABLblqZhAbZhXwjouLX1ofTabhcSDV_0rLV9USb4HqsC6lTfAJbIp08AkVHfkL5i1WSU3KCkyc4wAcj_rlrkCIM2u4QB0b";
    public final static String BASEURIURL = "https://api.na2.echosign.com:443/api/rest/v5/base_uris";
    
	@GetMapping("/base_uris")
	public String getBaseURIForAPI() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Access-Token", ACCESSTOKEN);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<BaseURIResponse> response = restTemplate.exchange(BASEURIURL, HttpMethod.GET, entity, BaseURIResponse.class);        
        System.out.println(response.getBody());
		logger.info(response.getBody().toString());
	    String apiAccessPoint = (String) response.getBody().getApi_access_point() + "api/rest/v5";
	    logger.info("Base URI : " + apiAccessPoint);
	    return apiAccessPoint;
	}

}
