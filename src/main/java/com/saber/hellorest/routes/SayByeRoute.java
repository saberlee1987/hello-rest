package com.saber.hellorest.routes;

import com.saber.hellorest.services.impl.HelloServiceImpl;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SayByeRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from(String.format("direct:%s", Routes.SAY_BYE_ROUTE_GATEWAY))
                .routeId(Routes.SAY_BYE_ROUTE_GATEWAY)
                .routeGroup(Routes.SAY_BYE_ROUTE_GROUP)
                .log("sayBye called with firstName ${in.header.firstName} , lastName ${in.header.lastName}")
                .bean("helloService", "sayBye")
                .log("Response sayBye ===> ${in.body}")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
        ;
    }
}
