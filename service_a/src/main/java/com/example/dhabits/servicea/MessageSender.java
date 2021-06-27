package com.example.dhabits.servicea;

import com.example.dhabits.servicea.model.Person;

public interface MessageSender {

    void sendData(Person data) throws Exception;
}
