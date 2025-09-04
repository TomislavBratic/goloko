package com.example.goloko.subscriptionplan.application;

import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlanRepository;
import com.example.goloko.subscriptionplan.web.request.CreateSubscriptionPlanRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionPlanService {
SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlanService(SubscriptionPlanRepository subscriptionPlanRepository) {
        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }
@Transactional
    public SubscriptionPlan create(CreateSubscriptionPlanRequest request) {

        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        subscriptionPlan.setName(request.name());
        subscriptionPlan.setMaxLocations(request.maxLocations());
        subscriptionPlan.setDurationMonths(request.durationMonths());
        subscriptionPlan.setPrice(request.price());

        return subscriptionPlanRepository.save(subscriptionPlan);
    }

    public Optional<SubscriptionPlan> get(Long id)
    {
        return subscriptionPlanRepository.findById(id);
    }
}
