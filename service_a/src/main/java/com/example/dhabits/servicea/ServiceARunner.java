package com.example.dhabits.servicea;

import com.example.dhabits.servicea.model.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ServiceARunner implements CommandLineRunner {

    private final MessageGenerator messageGenerator;
    private final MessageSender messageSender;

    public ServiceARunner(MessageGenerator messageGenerator, MessageSender messageSender) {
        this.messageGenerator = messageGenerator;
        this.messageSender = messageSender;
    }

    @Override
    public void run(String... args) {

        final BlockingQueue<Person> taskQueue = new ArrayBlockingQueue<>(3);

        ExecutorService service = Executors.newCachedThreadPool();

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