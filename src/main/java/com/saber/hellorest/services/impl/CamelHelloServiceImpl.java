package com.saber.hellorest.services.impl;

import com.saber.hellorest.dto.MessageResponseDto;
import com.saber.hellorest.routes.Headers;
import com.saber.hellorest.routes.Routes;
import com.saber.hellorest.services.HelloService;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service(value = "camelService")
@RequiredArgsConstructor
public class CamelHelloServiceImpl implements HelloService {

    private final ProducerTemplate producerTemplate;

    @Override
    public MessageResponseDto sayHello(String firstName, String lastName) {
        Exchange responseExchange = producerTemplate.send(String.format("direct:%s", Routes.SAY_HELLO_ROUTE_GATEWAY), exchange -> {
            exchange.getIn().setHeader(Headers.firstName, firstName);
            exchange.getIn().setHeader(Headers.lastName, lastName);
        });
        handleException(responseExchange);
        return responseExchange.getIn().getBody(MessageResponseDto.class);
    }

    @Override
    public MessageResponseDto sayBye(String firstName, String lastName) {
        Exchange responseExchange = producerTemplate.send(String.format("direct:%s", Routes.SAY_BYE_ROUTE_GATEWAY), exchange -> {
            exchange.getIn().setHeader(Headers.firstName, firstName);
            exchange.getIn().setHeader(Headers.lastName, lastName);
        });
        handleException(responseExchange);
        return responseExchange.getIn().getBody(MessageResponseDto.class);
    }

    private void handleException(Exchange exchange) {
        Integer statusCode = exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);
        if (statusCode != HttpStatus.OK.value()) {
            throw new RuntimeException("exception runtime");
        }
    }
}
