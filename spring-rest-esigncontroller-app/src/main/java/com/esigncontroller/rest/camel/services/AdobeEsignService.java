package com.esigncontroller.rest.camel.services;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AdobeEsignService {
	
    @Produce
    private ProducerTemplate template;
	
	//currently not working , need to find a way to execute the 1) Authorization Token request
	//which we did from browser as below ,should return the code value
	@GetMapping("/initToken")
	public String initAuthTokenRequest() throws ClientProtocolException, IOException {
		    String searchurl = "https://secure.na2.echosign.com/public/oauth?redirect_uri=https://localhost:8443/oauth/test&response_type=code&client_id=CBJCHBCAABAAxaDkAU93ynVnvNDZ7H4pG8AZLq26Ws1L&scope=user_login:self+agreement_write:account&state=testing";
		    HttpClient httpClient = HttpClientBuilder.create().build();
		    HttpGet httpget = new HttpGet(searchurl);
		    httpget.addHeader("content-type", "application/x-www-form-urlencoded");
		    HttpResponse response;
		    try {
		        response = httpClient.execute(httpget);
		        HttpEntity entity = response.getEntity();
		        if (entity != null) {
		            return EntityUtils.toString(entity);
		        }
		    } catch (ClientProtocolException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return null;
	}

	//1) First execute the following url in browser to get the AuthorizationToken
	//https://secure.eu1.echosign.com/public/oauth?redirect_uri=https://localhost:8443/public/oauth&response_type=code&client_id=CBJCHBCAABAATbPXDJdtaYYvjMjjh7ncQ0t_Ch8n4Z9o&scope=user_login:self+agreement_write:self&state=testing
	@GetMapping("/public/oauth")
	public String getAuthorizationTokenDetails(HttpServletRequest request) {
	    String uri = request.getRequestURL().toString() + "?" + request.getQueryString();
	    MultiValueMap<String, String> parameters =
	            UriComponentsBuilder.fromUriString(uri).build().getQueryParams();
	    List<String> code_list = parameters.get("code");
	    List<String> api_access_point_list = parameters.get("api_access_point");
	    List<String> web_access_point_list = parameters.get("web_access_point");
	    String code = code_list.get(0);
	    String api_access_point = api_access_point_list.get(0);
	    String web_access_point = web_access_point_list.get(0);
	    System.out.println("param1: " + code_list.get(0));
	    return "Authorization Token successfully granted for 5 minutes:" 
	    		+"Code: " + code
	    		+"ApiAccessPoint: " + api_access_point
	    		+"WebAccessPoint: " + web_access_point;
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
	
	//2) Access token request using the code/authorization code 
	//retrieved and stored in getAuthorizationTokenDetails method above
	//Currently not able to generate for trial account and and need enterprise account 
	//so will use harcoded value from the swagger API to test for now
/*	@PostMapping(value="/getAccessToken",headers = "Accept=application/json", produces = "application/json")
	public AccessTokenResponse getAccessToken(@Valid @RequestBody AccessTokenRequest accessTokenRequest) {
		System.out.println(accessTokenRequest);
		accessTokenRequest.setCode(AuthorizationCode);
		//AccessTokenRequest responsefromcamel = (AccessTokenRequest) template.sendBody("direct:weather", ExchangePattern.InOut, accessTokenRequest);
		RestTemplate restTemplate = new RestTemplate();
		//AccessTokenResponse accessTokenResponse = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+responsefromcamel.getCity()+","+responsefromcamel.getCountry()+"&APPID="+responsefromcamel.getKey()+"", AccessTokenResponse.class);
		//AccessTokenResponse accessTokenResponse = restTemplate.getForObject("https://secure.na2.echosign.com/oauth/token", AccessTokenResponse.class);
		AccessTokenResponse accessTokenResponse = restTemplate.postForObject("https://secure.na2.echosign.com/oauth/token", accessTokenRequest, AccessTokenResponse.class);
		logger.info(accessTokenResponse.toString());
		return accessTokenResponse;	
	}*/
}
