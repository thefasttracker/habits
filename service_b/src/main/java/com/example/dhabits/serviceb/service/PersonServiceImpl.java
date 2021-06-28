package com.example.dhabits.serviceb.service;

import com.example.dhabits.serviceb.model.Person;
import com.example.dhabits.serviceb.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonByPassport(int passport) {
        return personRepository.findByPassport(passport);
    }
}
