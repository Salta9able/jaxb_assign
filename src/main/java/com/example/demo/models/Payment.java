package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@Data
public class Payment {
    @Id
    @JsonProperty("id")
    private long id;
    @JsonProperty("supplier_id")
    private long supplier_id;
    @JsonProperty("account")
    private String account;
    @JsonProperty("amount")
    private double amount;

    @Transient
    @JsonProperty("command")
    private String command;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("date")
    private LocalDateTime date;

}
