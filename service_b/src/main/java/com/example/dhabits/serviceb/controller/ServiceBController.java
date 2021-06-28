package com.example.dhabits.serviceb.controller;

import com.example.dhabits.serviceb.model.dto.PersonDTO;
import com.example.dhabits.serviceb.service.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//TODO Сделать сохранение в db
@RestController
@RequestMapping({
        "/dataservice",
        "/v1.0/persons",
        })
@Slf4j
public class ServiceBController {

    private final PersonServiceImpl personService;

    public ServiceBController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    private enum ResponseMsg {
        SUCCESS, FAIL;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processPostRequest(@RequestBody @Valid PersonDTO person, Errors errors) {

        log.info("   --- processPostRequest(): " + person);

        if (errors.hasErrors()) {
            return new ResponseEntity<>(ResponseMsg.FAIL.name(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ResponseMsg.SUCCESS.name(), HttpStatus.OK);
    }
}
