package com.example.dhabits.serviceb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

    @NotNull
    @Size(min=16, max=19, message="id must be at least 16 and up to 19 characters long")
    private String id;

    private String fio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String contacts;

    private String photo;

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", fio='" + fio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", contact='" + contacts + '\'' +
                '}';
    }
}
