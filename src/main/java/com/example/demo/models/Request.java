package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Request {
    @JsonProperty("request")
    private Payment payment;
}
