package com.example.goloko.subscriptionplan.web;

import com.example.goloko.subscriptionplan.application.SubscriptionPlanService;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import com.example.goloko.subscriptionplan.web.request.CreateSubscriptionPlanRequest;
import com.example.goloko.subscriptionplan.web.response.CreateSubscriptionPlanResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping("api/subscription_plan")
public class SubscriptionPlanController {

    private final SubscriptionPlanService service;
    public SubscriptionPlanController(SubscriptionPlanService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateSubscriptionPlanResponse> create(@Valid @RequestBody CreateSubscriptionPlanRequest request){
        SubscriptionPlan saved = service.create(request);
        return ResponseEntity.created(URI.create("api/subscription_plan" + saved.getId()))
                .body(CreateSubscriptionPlanResponse.from(saved));
    }
}
