package com.esigncontroller.rest.camel.services;

import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.*;

import com.esigncontroller.rest.camel.requestbody.Request;
import com.esigncontroller.rest.camel.responsebody.Response;

import javax.validation.Valid;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldRestService {

    @GetMapping("/test")
    public String helloworld(){
        return "Hey Sai, what's up?";
    }

    @Produce
    private ProducerTemplate template;

    @GetMapping("/{name}")
    public Response hellofromcamel(final @PathVariable String name){
        String responsefromcamel =  (String) template.sendBody("direct:hello", ExchangePattern.InOut,name);
        Response response = new Response(); 
        response.setMessage(responsefromcamel);
        return response;
    }

    @PostMapping(value="/send",headers = "Accept=application/json", produces = "application/json")
    public Response sendtocamel(@Valid @RequestBody Request request) {
        System.out.println(request);
        Request responsefromcamel = (Request) template.sendBody("direct:hello", ExchangePattern.InOut, request);
        Response response = new Response();
        response.setMessage(responsefromcamel.getMessage());
        return response;
    }
}