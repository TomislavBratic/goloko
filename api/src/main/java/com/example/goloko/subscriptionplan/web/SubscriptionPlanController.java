package com.example.goloko.subscriptionplan.web;

import com.example.goloko.subscriptionplan.application.SubscriptionPlanService;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import com.example.goloko.subscriptionplan.web.request.CreateSubscriptionPlanRequest;
import com.example.goloko.subscriptionplan.web.response.SubscriptionPlanResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("api/subscription_plans")
public class SubscriptionPlanController {

    private final SubscriptionPlanService service;
    public SubscriptionPlanController(SubscriptionPlanService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SubscriptionPlanResponse> create(@Valid @RequestBody CreateSubscriptionPlanRequest request){
        SubscriptionPlanResponse saved = service.create(request);
        return ResponseEntity.created(URI.create("api/subscription_plan" + saved.id()))
                .body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlanResponse> get(@PathVariable Long id)
    {
        return ResponseEntity.of(service.get(id));
    }
}
