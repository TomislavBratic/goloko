package com.example.goloko.subscription_plan.web;

import com.example.goloko.subscription_plan.application.SubscriptionPlanService;
import com.example.goloko.subscription_plan.web.request.CreateSubscriptionPlanRequest;
import com.example.goloko.subscription_plan.web.response.SubscriptionPlanResponse;
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
