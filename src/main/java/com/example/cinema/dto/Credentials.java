package com.example.cinema.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Credentials {

    @NotNull
    private String login;
    @NotNull
    private String password;
}
