package com.example.demo.service;

import com.example.demo.models.Payment;
import com.example.demo.models.PaymentJAXB;
import com.example.demo.models.Request;
import com.example.demo.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private final PaymentRepository paymentRepository;

    public RequestService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentJAXB checking(Request request) {
        Payment p1 = request.getPayment();
        PaymentJAXB paymentJAXB = new PaymentJAXB();
        paymentJAXB.setId(String.valueOf(p1.getId()));
        paymentJAXB.setP_id(p1.getSupplier_id());
        paymentJAXB.setDts(p1.getDate().toString());

        if (request.getPayment().getCommand().equals("pay")) {
            paymentRepository.save(p1);
            paymentJAXB.setMessage("PAYMENT CONFIRMED");
            paymentJAXB.setStatus(1);
            return paymentJAXB;
        }
        else if (request.getPayment().getCommand().equals("check")){
            paymentJAXB.setMessage("ACCOUNT EXISTS");
            paymentJAXB.setStatus(0);
            return paymentJAXB;
        }
        else throw new RuntimeException();
    }
}
