package com.example.goloko.payment.web;


import com.example.goloko.payment.application.PaymentService;
import com.example.goloko.payment.web.request.CreatePaymentRequest;
import com.example.goloko.payment.web.response.CreatePaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;
    public PaymentController(PaymentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreatePaymentResponse> create(@RequestBody CreatePaymentRequest request){
        CreatePaymentResponse saved = service.create(request);

        return ResponseEntity.created(URI.create("/api/payments"))
                .body(saved);
    }
}
