package com.example.dhabits.servicea;

import com.example.dhabits.serviceb.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ServiceA {

    public static void main(String[] args) {

        MessageGenerator messageGenerator = new MessageGeneratorImpl();
        MessageSender messageSender = new MessageSenderImpl();

        final BlockingQueue<Person> taskQueue = new ArrayBlockingQueue<>(3);

        ExecutorService service = Executors.newFixedThreadPool(2);

        //Producer
        new Thread(() -> {
            for(int i = 0; i < 3; i++) {
                try {
                    Person person = messageGenerator.generateData();
                    if (i == 1) {
                        person.setId("123");
                    }
                    taskQueue.put(person);
                    log.info("add task #" + i);
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) { /*NOP*/; }
            }
        }).start();

        //Consumer
        while(true) {
            try {
                Person person = taskQueue.take();
                service.execute(() -> {
                    try {
                        messageSender.sendData(person);
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