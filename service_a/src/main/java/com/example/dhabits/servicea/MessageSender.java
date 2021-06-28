package com.example.dhabits.servicea;

import com.example.dhabits.servicea.model.dto.Person;

public interface MessageSender {

    void sendData(Person data) throws Exception;
}
