package com.saber.hellorest.routes;

import com.saber.hellorest.dto.MessageResponseDto;
import com.saber.hellorest.services.impl.HelloServiceImpl;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class SayHelloRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from(String.format("direct:%s", Routes.SAY_HELLO_ROUTE_GATEWAY))
                .routeId(Routes.SAY_HELLO_ROUTE_GATEWAY)
                .routeGroup(Routes.SAY_HELLO_ROUTE_GROUP)
                .log("sayHello called with firstName ${in.header.firstName} , lastName ${in.header.lastName}")
                .bean(HelloServiceImpl.class, "sayHello")
                .log("Response sayHello ===> ${in.body}")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
        ;
    }
}
