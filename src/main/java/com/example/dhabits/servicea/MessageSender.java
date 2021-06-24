package com.example.dhabits.servicea;

import com.example.dhabits.serviceb.model.UserData;

public interface MessageSender {

    void sendData(UserData data) throws Exception;
}
