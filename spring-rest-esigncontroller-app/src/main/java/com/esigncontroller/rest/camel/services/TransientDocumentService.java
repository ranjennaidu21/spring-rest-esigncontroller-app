package com.esigncontroller.rest.camel.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.validation.Valid;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.esigncontroller.rest.camel.requestbody.TransientDocumentRequest;
import com.esigncontroller.rest.camel.responsebody.TransientDocumentResponse;
import com.esigncontroller.rest.camel.util.GlobalConstants;



@RestController
public class TransientDocumentService {

    @Produce
    private ProducerTemplate template;
    
    private static final Logger logger = LoggerFactory.getLogger(TransientDocumentService.class);
    
    private static final String TRANSIENT_DOCUMENTS_ENDPOINT = "/transientDocuments";

    public final static String POSTTRANSIENTDOCUMENTSURL = GlobalConstants.API_ACCESS_POINT + GlobalConstants.REST_API_VERSION + TRANSIENT_DOCUMENTS_ENDPOINT;

    public final static String REQUEST_PATH = "com/esigncontroller/rest/camel/documents/";
    
    @PostMapping("/transientDocuments")
    public TransientDocumentResponse uploadTransientDocument(@Valid @RequestBody TransientDocumentRequest transientDocumentRequest) throws IOException {

    	// Create header list for the request.
    	HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", GlobalConstants.ACCESS_TOKEN);
        headers.set("accept","application/json");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Get a reference to the file to be uploaded to Adobe Sign.
        String pathToFile = REQUEST_PATH + transientDocumentRequest.getFileToBeUploaded();
        URL fileUrl = ClassLoader.getSystemResource(pathToFile);
        File fileToUpload = new File(fileUrl.getPath());
        
		RestTemplate restTemplate = new RestTemplate();
		
		// Meta-data associated with the file.
    	MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    	body.add("Mime-Type", transientDocumentRequest.getMimeType());
    	body.add("File-Name", transientDocumentRequest.getFileName());
    	body.add("File", fileToUpload);
    	
    	HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);    
        ResponseEntity<TransientDocumentResponse> response = restTemplate.exchange(POSTTRANSIENTDOCUMENTSURL, HttpMethod.POST, entity, TransientDocumentResponse.class);  
        System.out.println(response.getBody());
		logger.info(response.getBody().toString());
		
	    return response.getBody();
    }
 
}