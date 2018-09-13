package com.esigncontroller.rest.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class WeatherProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception { 	
        System.out.println("Printing the values in Weather processor ");
        System.out.println("WeatherProcessor.process");
        System.out.println("exchange = [" + exchange + "]");
        exchange.getIn().setBody(exchange.getIn().getBody());
    }
}
