package com.example.dhabits.serviceb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class Passport {

    @NotBlank
    private int numberAndSeries;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @NotBlank
    private String issuedBy;

}
