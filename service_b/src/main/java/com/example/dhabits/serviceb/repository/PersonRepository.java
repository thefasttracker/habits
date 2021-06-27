package com.example.dhabits.serviceb.repository;

import com.example.dhabits.serviceb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
