package com.esigncontroller.rest.camel.util;

public class GlobalConstants {
	
	//need to find away to store the value based URL provided from BaseUriService.getBaseURI() for each user
	public final static String API_ACCESS_POINT = "https://api.eu1.echosign.com/";
	
	public final static String REST_API_VERSION = "api/rest/v6";
	
	//need to find a way to generate this access token which is active for 5 minutes and store the value here.
	//need to refresh for every 5 minutes
	public static final String ACCESS_TOKEN  = "Bearer 3AAABLblqZhCMGthQfVb8Oi6aJH1viuinWk8HasfXigB4lvG3_6qYzyy7yL24jrkMTRzBOGwEQBJbOSa5CSOA2H6ZEDk5tYu7";
}
