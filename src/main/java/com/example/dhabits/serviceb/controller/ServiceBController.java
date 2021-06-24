package com.example.dhabits.serviceb.controller;

import com.example.dhabits.serviceb.model.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;


@RestController
@RequestMapping("/dataservice")
@Slf4j
public class ServiceBController {

    private final String[] responseMsg = {"success", "fail"};
    private final Random random = new Random();

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String processPostRequest(@RequestBody @Valid UserData userData) {

        log.info("   --- processPostRequest(): " + userData);

        return responseMsg[random.nextInt(2)];
    }
}
