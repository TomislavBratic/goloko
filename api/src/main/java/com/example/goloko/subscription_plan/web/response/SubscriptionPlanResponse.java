package com.example.goloko.subscription_plan.web.response;

import java.math.BigDecimal;

public record SubscriptionPlanResponse(
        Long id,
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {

}
