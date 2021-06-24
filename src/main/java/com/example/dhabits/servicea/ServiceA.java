package com.example.dhabits.servicea;

import com.example.dhabits.serviceb.model.UserData;
import com.example.dhabits.servicea.MessageGeneratorImpl;
import com.example.dhabits.servicea.MessageSenderImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceA {

    public static void main(String[] args) throws Exception {

        MessageGenerator messageGenerator = new MessageGeneratorImpl();
        MessageSender messageSender = new MessageSenderImpl();

        for(int i = 0; i < 3; i++) {
            log.info("Send Http POST request #" + i);
            UserData userData = messageGenerator.generateData();
            if (i == 1) {
                userData.setId("123");
            }
            messageSender.sendData(userData);
            Thread.sleep(1000);
        }
    }
}