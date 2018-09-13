package com.esigncontroller.rest.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.esigncontroller.rest.camel.processor.CustomerProcessor;
import com.esigncontroller.rest.camel.processor.GreetingProcessor;
import com.esigncontroller.rest.camel.processor.WeatherProcessor;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
            from("direct:hello")
                    .routeId("direct:hello")
                    .doTry()
                        .to("log:INFO?showBody=true&showHeaders=true")
                        //.convertBodyTo(String.class)
                        .log("===>doTry :: ${body}")
                        .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {
                                System.out.println("HelloWorldProcessor");
                                System.out.println("all is well");
                                exchange.getIn().setHeader("GREETING","Hello Sai!!!");
                            }
                        })
                        .process(new GreetingProcessor())
                    .log("===>end doTry :: ${body}")
                    .doCatch(Exception.class)
                        .to("log:INFO?showBody=true&showHeaders=true")
                        .convertBodyTo(String.class)
                        .log("===>catch error :: ${body}")
                    .end();

            from("direct:secondroute")
                    .to("log:INFO:: Hello ${body}")
                    .end();
            
            from("direct:customer")
            .routeId("direct:customer")
            .doTry()
                .to("log:INFO?showBody=true&showHeaders=true")
                //.convertBodyTo(String.class)
                .log("===>doTry :: ${body}")
                .process(new CustomerProcessor())
            .log("===>end doTry :: ${body}")
            .doCatch(Exception.class)
                .to("log:INFO?showBody=true&showHeaders=true")
                .convertBodyTo(String.class)
                .log("===>catch error :: ${body}")
            .end();
            
            from("direct:weather")
            .routeId("direct:weather")
            .doTry()
                .to("log:INFO?showBody=true&showHeaders=true")
                //.convertBodyTo(String.class)
                .log("===>doTry :: ${body}")
                .process(new WeatherProcessor())
            .log("===>end doTry :: ${body}")
            .doCatch(Exception.class)
                .to("log:INFO?showBody=true&showHeaders=true")
                .convertBodyTo(String.class)
                .log("===>catch error :: ${body}")
            .end();
    }
}
