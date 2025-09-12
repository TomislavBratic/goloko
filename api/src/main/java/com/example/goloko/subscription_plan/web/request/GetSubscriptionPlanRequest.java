package com.example.goloko.subscriptionplan.web.request;

import java.math.BigDecimal;

public record GetSubscriptionPlanRequest(
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {
}
