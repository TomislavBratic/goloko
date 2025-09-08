package com.example.goloko.client.web.response;

import com.example.goloko.client.domain.Client;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public record ClientResponse(
        String businessName,
        String verificationText,
        String subscriptionPlanName,
        Integer maxLocations,
        Integer subscriptionDuration,
        BigDecimal subscriptionPrice


) {
    public static ClientResponse from(Client c){
        SubscriptionPlan s = c.getSubscriptionPlan();
        return new ClientResponse(c.getBusinessName(),c.getVerificationText(),s.getName(),s.getMaxLocations(),s.getDurationMonths(),s.getPrice());
    }

}
