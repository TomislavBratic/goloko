package com.example.goloko.payment.web.response;

import com.example.goloko.payment.domain.Status;

import java.math.BigDecimal;

public record CreatePaymentResponse(
        String firstName,
        String lastName,
        String businessName,
        String subscriptionPlanName,
        BigDecimal amount,
        Status status
) {
}
