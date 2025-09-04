package com.example.goloko.subscriptionplan.web.response;

import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;

import java.math.BigDecimal;

public record SubscriptionPlanResponse(
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {
    public static SubscriptionPlanResponse from(SubscriptionPlan p){
        return new SubscriptionPlanResponse(p.getName(),p.getMaxLocations(), p.getDurationMonths(), p.getPrice());
    }

}
