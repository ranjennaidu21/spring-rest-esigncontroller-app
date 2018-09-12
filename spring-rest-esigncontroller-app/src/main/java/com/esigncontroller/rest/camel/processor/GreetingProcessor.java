package com.esigncontroller.rest.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GreetingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Printing the values inn greeting processor ");
        System.out.println("GreetingProcessor.process");
        System.out.println("exchange = [" + exchange + "]");
        System.out.println("exchange :: "+exchange.getIn().getHeader("GREETING"));
        exchange.getIn().setBody("Hello "+exchange.getIn().getBody() + " :: " +exchange.getIn().getHeader("GREETING"));
    }
}
