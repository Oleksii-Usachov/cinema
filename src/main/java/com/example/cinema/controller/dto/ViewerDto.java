package com.example.cinema.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ViewerDto {

    private Long id;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
