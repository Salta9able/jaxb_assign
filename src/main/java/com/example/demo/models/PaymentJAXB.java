package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentJAXB {
    @XmlAttribute
    private String id;
    @XmlElement
    private long p_id;
    @XmlAttribute
    private String dts;
    @XmlElement
    private int status;
    @XmlElement
    private String message;
}
