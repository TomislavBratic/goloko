package com.example.goloko.payment.web.request;

import com.example.goloko.payment.domain.Status;
import java.math.BigDecimal;

public record CreatePaymentRequest(
        Long userId,
        Long clientId,
        Long subscriptionPlanId,
        BigDecimal amount,
        Status status
) {
}
