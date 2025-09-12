package com.example.goloko.subscriptionplan.application;

import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlanRepository;
import com.example.goloko.subscriptionplan.web.mapper.SubscriptionPlanMapper;
import com.example.goloko.subscriptionplan.web.request.CreateSubscriptionPlanRequest;
import com.example.goloko.subscriptionplan.web.response.SubscriptionPlanResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionPlanService {
SubscriptionPlanRepository subscriptionPlanRepository;
SubscriptionPlanMapper subscriptionPlanMapper;

    public SubscriptionPlanService(SubscriptionPlanRepository subscriptionPlanRepository,
                                   SubscriptionPlanMapper subscriptionPlanMapper) {
        this.subscriptionPlanRepository = subscriptionPlanRepository;
        this.subscriptionPlanMapper = subscriptionPlanMapper;
    }
@Transactional
    public SubscriptionPlanResponse create(CreateSubscriptionPlanRequest request) {

        SubscriptionPlan subscriptionPlan = subscriptionPlanMapper.toEntity(request);
        subscriptionPlanRepository.save(subscriptionPlan);
        return subscriptionPlanMapper.toSubscriptionPlanResponse(subscriptionPlan);
    }

    public Optional<SubscriptionPlanResponse> get(Long id)
    {
        return subscriptionPlanRepository.findById(id).map(subscriptionPlanMapper::toSubscriptionPlanResponse);
    }
}
