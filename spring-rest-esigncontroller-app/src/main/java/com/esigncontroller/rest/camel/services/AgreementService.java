package com.esigncontroller.rest.camel.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esigncontroller.rest.camel.responsebody.AgreementByIdResponse;
import com.esigncontroller.rest.camel.responsebody.DeleteAgreementDocResponse;
import com.esigncontroller.rest.camel.responsebody.DocumentListResponse;
import com.esigncontroller.rest.camel.responsebody.UserAgreementListResponse;
import com.esigncontroller.rest.camel.util.GlobalConstants;

/*
 * Example:
 * agreement id = CBJCHBCAABAAoEsmqdufWDBKCM52i-5lroE6eYpP2m7y
 * doc id = 3AAABLblqZhDxrwoOt3W1UaPotZevekbVAZdAiNVvQGIXfwsaSCCZo7c7K3_3TTbo-BRRgxMeiIYtoMHwd2nRkWkl1IRrIVt1
*/


@RestController
public class AgreementService {

    @Produce
    private ProducerTemplate template;
    
    private static final Logger logger = LoggerFactory.getLogger(AgreementService.class);
    
    private static final String GET_AGREEMENTS_ENDPOINT = "/agreements";
    
    private static final String GET_AGREEMENTBYID_ENDPOINT = "/agreements/{agreementId}";
    
    private static final String GET_DOCID_ENDPOINT = "/agreements/{agreementId}/documents";
    
    private static final String GET_DOCFILESTREAM_ENDPOINT = "/agreements/{agreementId}/documents/{documentId}";
    
    public final static String GET_AGREEMENTS_URL = GlobalConstants.API_ACCESS_POINT + GlobalConstants.REST_API_VERSION + GET_AGREEMENTS_ENDPOINT;

    public final static String GET_AGREEMENTBYID_URL = GlobalConstants.API_ACCESS_POINT + GlobalConstants.REST_API_VERSION + GET_AGREEMENTBYID_ENDPOINT;
    
    public final static String GET_DOCID_OF_AGREEMENT_URL = GlobalConstants.API_ACCESS_POINT + GlobalConstants.REST_API_VERSION + GET_DOCID_ENDPOINT;
    
    public final static String GET_DOCFILESTREAM_OF_AGREEMENT_URL = GlobalConstants.API_ACCESS_POINT + GlobalConstants.REST_API_VERSION + GET_DOCFILESTREAM_ENDPOINT;
    
    public final static String DELETE_DOC_OF_AGREEMENT_URL = GlobalConstants.API_ACCESS_POINT + GlobalConstants.REST_API_VERSION + GET_DOCID_ENDPOINT;
    
    public final static String REQUEST_PATH = "com/esigncontroller/rest/camel/documents/";
      
    //Retrieves agreements for the user
    //TEST URL: https://localhost:8443/agreements
    @GetMapping("/agreements")
    public UserAgreementListResponse getAgreements(){
		RestTemplate restTemplate = new RestTemplate();
    	// Create header list for the request.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", GlobalConstants.ACCESS_TOKEN);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<UserAgreementListResponse> response = restTemplate.exchange(GET_AGREEMENTS_URL, HttpMethod.GET, entity, UserAgreementListResponse.class);
        
        System.out.println(response.getBody());
		logger.info(response.getBody().toString());
		
	    return response.getBody();
    }
    
    @GetMapping("/agreements/{agreementId}")
    public AgreementByIdResponse getAgreementById(@PathVariable String agreementId){
		RestTemplate restTemplate = new RestTemplate();
    	// Create header list for the request.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", GlobalConstants.ACCESS_TOKEN);

		Map<String, String> params = new HashMap<String, String>();
		params.put("agreementId", agreementId);
		
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<AgreementByIdResponse> response = restTemplate.exchange(GET_AGREEMENTBYID_URL, HttpMethod.GET, entity, AgreementByIdResponse.class,params);

        System.out.println(response.getBody());
		logger.info(response.getBody().toString());
		
	    return response.getBody();
    }
    
    //Retrieves the IDs of the documents of an agreement identified by agreementId
    //TEST URL: https://localhost:8443/agreements/CBJCHBCAABAAoEsmqdufWDBKCM52i-5lroE6eYpP2m7y/documents
    @GetMapping("/agreements/{agreementId}/documents")
    public DocumentListResponse getDocIdOfAgreement(@PathVariable String agreementId){
		RestTemplate restTemplate = new RestTemplate();
    	// Create header list for the request.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", GlobalConstants.ACCESS_TOKEN);

		Map<String, String> params = new HashMap<String, String>();
		params.put("agreementId", agreementId);
		
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<DocumentListResponse> response = restTemplate.exchange(GET_DOCID_OF_AGREEMENT_URL, HttpMethod.GET, entity, DocumentListResponse.class,params);
        HttpHeaders responseHeaders = response.getHeaders();
		response.getBody().getDocuments().get(0).seteTag(responseHeaders.getFirst("ETag"));
		
        System.out.println(response.getBody());
		logger.info(response.getBody().toString());
		
	    return response.getBody();
    }
    
    //Retrieves the file stream of a document of an agreement.
    //TEST URL: https://localhost:8443/agreements/CBJCHBCAABAAoEsmqdufWDBKCM52i-5lroE6eYpP2m7y/documents/3AAABLblqZhDxrwoOt3W1UaPotZevekbVAZdAiNVvQGIXfwsaSCCZo7c7K3_3TTbo-BRRgxMeiIYtoMHwd2nRkWkl1IRrIVt1
    @GetMapping("/agreements/{agreementId}/documents/{documentId}")
    public ResponseEntity<byte[]> getDocFileStreamOfAgreement(@PathVariable String agreementId,@PathVariable String documentId){
    	ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();

    	List<MediaType> supportedApplicationTypes = new ArrayList<MediaType>();
    	MediaType pdfApplication = new MediaType("application","pdf");
    	supportedApplicationTypes.add(pdfApplication);

    	byteArrayHttpMessageConverter.setSupportedMediaTypes(supportedApplicationTypes);
    	List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    	messageConverters.add(byteArrayHttpMessageConverter);
    	
    	RestTemplate restTemplate = new RestTemplate();
    	restTemplate.setMessageConverters(messageConverters);
    	// Create header list for the request.
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", GlobalConstants.ACCESS_TOKEN);
		headers.setContentType(MediaType.parseMediaType("application/pdf"));

		Map<String, String> params = new HashMap<String, String>();
		params.put("agreementId", agreementId);
		params.put("documentId", documentId);
		
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(GET_DOCFILESTREAM_OF_AGREEMENT_URL, HttpMethod.GET, entity, byte[].class,params);
	    return response;
    }
    
    //TO DO : DELETE /agreements/{agreementId}/documents >> Deletes all the documents of an agreement
    // The ETAG value of the document to be deleted can be retrieved by calling /agreements/{agreementId}/documents
    //TEST URL: https://localhost:8443/agreements/CBJCHBCAABAAvs3vXL0B5LGZGN-U5emdtQ38uNNq6vUV/documents/432ABA253823BBC32B5381BA24CE43.4D54FA57C93BA83731352917FEF5A82
    @DeleteMapping("/agreements/{agreementId}/documents/{eTag}")
    public HttpStatus deleteAllDocOfAgreement(@PathVariable String agreementId,@PathVariable String eTag){
    	
		RestTemplate restTemplate = new RestTemplate();
    	// Create header list for the request.
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", GlobalConstants.ACCESS_TOKEN);
		//This is ETAG Value need to be sent by user after received from the getAgreementById endpoint above.
		//eg: for agreement id->CBJCHBCAABAAvs3vXL0B5LGZGN-U5emdtQ38uNNq6vUV
		//ETAG value is A432ABA253823BBC32B5381BA24CE43.4D54FA57C93BA83731352917FEF5A82
		headers.set("If-Match", eTag);

		Map<String, String> params = new HashMap<String, String>();
		params.put("agreementId", agreementId);
		
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(DELETE_DOC_OF_AGREEMENT_URL, HttpMethod.DELETE, entity, String.class,params);
        HttpStatus statusCode = response.getStatusCode();
        return statusCode;
    }
}