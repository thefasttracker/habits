package com.example.dhabits.serviceb.controller;

import com.example.dhabits.serviceb.model.Person;
import com.example.dhabits.serviceb.repository.PersonRepository;
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
        "/v2.0/persons",
        })
@Slf4j
public class ServiceBController {

    private PersonRepository personRepository;

    public ServiceBController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private enum ResponseMsg {
        SUCCESS, FAIL;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processPostRequest(@RequestBody @Valid Person person, Errors errors) {

        log.info("   --- processPostRequest(): " + person);

        if (errors.hasErrors()) {
            return new ResponseEntity<>(ResponseMsg.FAIL.name(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ResponseMsg.SUCCESS.name(), HttpStatus.OK);
    }
}
