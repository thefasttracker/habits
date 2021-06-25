package com.example.dhabits.servicea;

import com.example.dhabits.serviceb.model.UserData;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ServiceA {

    public static void main(String[] args) throws Exception {

        MessageGenerator messageGenerator = new MessageGeneratorImpl();
        MessageSender messageSender = new MessageSenderImpl();

        ExecutorService service = Executors.newCachedThreadPool();

        for(int i = 0; i < 3; i++) {
            log.info("Send Http POST request #" + i);
            UserData userData = messageGenerator.generateData();
            if (i == 1) {
                userData.setId("123");
            }
            service.submit(() -> {
                try {
                    messageSender.sendData(userData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(1000);
        }
    }
}