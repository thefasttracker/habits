package com.example.dhabits.serviceb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @Id
    @NotBlank
    @Size(min=16, max=19, message="id must be at least 16 and up to 19 characters long")
    private String id;

    @NotBlank
    private String fio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String contacts;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @NotBlank
    private String photo;

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", fio='" + fio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", contact='" + contacts + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
