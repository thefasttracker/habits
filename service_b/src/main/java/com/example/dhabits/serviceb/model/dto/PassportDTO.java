package com.example.dhabits.serviceb.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassportDTO {

    @NotBlank
    @Digits(integer=10, fraction=0, message="Invalid passport number")
    private int numberAndSeries;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @NotBlank
    private String issuedBy;

    private PersonDTO person;

}
