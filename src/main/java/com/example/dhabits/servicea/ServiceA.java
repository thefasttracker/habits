package com.example.dhabits.servicea;

import com.example.dhabits.serviceb.model.UserData;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ServiceA {

    public static void main(String[] args) {

        MessageGenerator messageGenerator = new MessageGeneratorImpl();
        MessageSender messageSender = new MessageSenderImpl();

        final BlockingQueue<UserData> taskQueue = new ArrayBlockingQueue<>(3);

        ExecutorService service = Executors.newFixedThreadPool(2);

        //Producer
        new Thread(() -> {
            for(int i = 0; i < 3; i++) {
                try {
                    UserData userData = messageGenerator.generateData();
                    if (i == 1) {
                        userData.setId("123");
                    }
                    taskQueue.put(userData);
                    log.info("add task #" + i);
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) { /*NOP*/; }
            }
        }).start();

        //Consumer
        while(true) {
            try {
                UserData userData = taskQueue.take();
                service.execute(() -> {
                    try {
                        messageSender.sendData(userData);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}