package com.example.cinema.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String returnCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String returnMessage;
    @JsonUnwrapped
    private T commonBody;
}
