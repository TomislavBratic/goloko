package com.example.goloko.subscriptionplan.web.response;

import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;

import java.math.BigDecimal;

public record CreateSubscriptionPlanResponse(
        String name,
        Integer maxLocations,
        Integer durationMonths,
        BigDecimal price
) {
    public static CreateSubscriptionPlanResponse from(SubscriptionPlan p){
        return new CreateSubscriptionPlanResponse(p.getName(),p.getMaxLocations(), p.getDurationMonths(), p.getPrice());
    }

}
