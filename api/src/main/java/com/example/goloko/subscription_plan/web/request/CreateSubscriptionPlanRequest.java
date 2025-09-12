package com.example.goloko.subscription_plan.web.request;

import java.math.BigDecimal;

public record CreateSubscriptionPlanRequest(
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {
}
