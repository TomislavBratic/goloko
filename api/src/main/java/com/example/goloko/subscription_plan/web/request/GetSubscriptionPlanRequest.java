package com.example.goloko.subscription_plan.web.request;

import java.math.BigDecimal;

public record GetSubscriptionPlanRequest(
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {
}
