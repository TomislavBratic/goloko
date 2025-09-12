package com.example.goloko.subscription_plan.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository <SubscriptionPlan,Long> {
}
