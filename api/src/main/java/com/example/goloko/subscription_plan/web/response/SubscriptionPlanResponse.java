package com.example.goloko.subscriptionplan.web.response;

import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;

import java.math.BigDecimal;

public record SubscriptionPlanResponse(
        Long id,
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {

}
