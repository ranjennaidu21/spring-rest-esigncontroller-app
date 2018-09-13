package com.esigncontroller.rest.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomerProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Printing the values in Customer processor ");
        System.out.println("CustomerProcessor.process");
        System.out.println("exchange = [" + exchange + "]");
        exchange.getIn().setBody(exchange.getIn().getBody());
    }
}
