package com.esigncontroller.rest.camel.route;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

/*    	restConfiguration().component("jetty")
        .bindingMode(RestBindingMode.json)
        .dataFormatProperty("prettyPrint", "true")
        .port(8443);
    	
        rest().description("Base URI Service")
        .consumes("application/json").produces("application/json")

        .get("/base_uris").description("Find user by id").outType(String.class)
        .to("log:INFO?showBody=true&showHeaders=true");*/
    		
        /*from("direct:baseuri")
        .routeId("direct:baseuri")
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
        
    		rest()
    		.get("/base_uris")
    		.to("log:INFO?showBody=true&showHeaders=true")
            .to("log:INFO:: ${body}");*/
/*            from("direct:hello")
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
            .end();*/
    }
}
