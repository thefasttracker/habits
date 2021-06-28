package com.example.dhabits.servicea.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class Passport {

    private Long id;

    @NotBlank
    @Digits(integer=10, fraction=0, message="Invalid passport number")
    private int numberAndSeries;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @NotBlank
    private String issuedBy;

    private Person owner;

}
