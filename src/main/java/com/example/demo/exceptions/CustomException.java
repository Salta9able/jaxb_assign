package com.example.demo.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement(name = "exception")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomException {
    @XmlElement
    private String message;
}
