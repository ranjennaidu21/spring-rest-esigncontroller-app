package com.esigncontroller.rest.camel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esigncontroller.rest.camel.responsebody.Quote;




/*A RESTful service has been stood up at http://gturnquist-quoters.cfapps.io/api/random. It randomly fetches quotes about Spring Boot and returns them as a JSON document.

If you request that URL through your web browser or curl, you’ll receive a JSON document that looks something like this:

{
    "type": "success",
    "value": {
        "id": 7,
        "quote": "The real benefit of Boot, however, is that it's just Spring. That means any direction the code takes, regardless of complexity, I know it's a safe bet."
    }
}*/

@RestController
@RequestMapping("/externalapi")
public class ExternalApiTest1Service {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// add mapping for GET /customers
	@GetMapping("/quote/")
	public Quote getQuote() {
		
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        logger.info(quote.toString());
		return quote;
		
	}
}


















