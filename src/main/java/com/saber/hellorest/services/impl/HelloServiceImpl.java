package com.saber.hellorest.services.impl;

import com.saber.hellorest.dto.MessageResponseDto;
import com.saber.hellorest.services.HelloService;
import org.apache.camel.Header;
import org.springframework.stereotype.Service;

@Service(value = "helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public MessageResponseDto sayHello(@Header(value = "firstName") String firstName,
                                       @Header(value = "lastName") String lastName) {
        return messageResponseDto(firstName,lastName,"Hello ");
    }
    @Override
    public MessageResponseDto sayBye(@Header(value = "firstName") String firstName,
                                     @Header(value = "lastName") String lastName) {
        return messageResponseDto(firstName,lastName,"Bye Bye ");
    }
    private MessageResponseDto messageResponseDto(String firstName, String lastName,String messageText){
        String message = messageText.concat(firstName).concat(" ").concat(lastName);
        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setMessage(message);
        return responseDto;
    }
}
