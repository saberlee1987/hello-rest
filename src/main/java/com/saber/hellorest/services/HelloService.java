package com.saber.hellorest.services;

import com.saber.hellorest.dto.MessageResponseDto;

public interface HelloService {
    MessageResponseDto sayHello(String firstName, String lastName);
    MessageResponseDto sayBye(String firstName, String lastName);
}
