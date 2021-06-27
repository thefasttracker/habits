package com.example.dhabits.serviceb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Digits(integer=10, fraction=0, message="Invalid passport number")
    private int numberAndSeries;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @NotBlank
    private String issuedBy;

    @OneToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;

}
