package com.esigncontroller.rest.camel.services;

import lombok.Data;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
public class HelloWorldRestService {

    @GetMapping("/helloworld")
    public String helloworld(){
        return "Hey Sai, what's up?";
    }

    @Produce
    private ProducerTemplate template;

    @GetMapping("/hello-from-camel/{name}")
    public Response hellofromcamel(final @PathVariable String name){
        String responsefromcamel =  (String) template.sendBody("direct:hello", ExchangePattern.InOut,name);
        Response response = new Response(); response.setMessage(responsefromcamel);
        return response;
    }

    @PostMapping(value="/send",headers = "Accept=application/json", produces = "application/json")
    public Response sendtocamel(@Valid @RequestBody Request request) {
        System.out.println(request);
        String responsefromcamel = (String) template.sendBody("direct:hello", ExchangePattern.InOut, request);
        Response response = new Response();
        response.setMessage(responsefromcamel);
        return response;
    }
}

@Data
@Validated
class Request
{
    @Size(min = 5,max = 10)
    String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}


@Data
class Response
{
    String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}

