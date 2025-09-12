package com.example.goloko.subscription_plan.web.mapper;
import com.example.goloko.subscription_plan.domain.SubscriptionPlan;
import com.example.goloko.subscription_plan.web.request.CreateSubscriptionPlanRequest;
import com.example.goloko.subscription_plan.web.response.SubscriptionPlanResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SubscriptionPlanMapper {
    SubscriptionPlanResponse toSubscriptionPlanResponse(SubscriptionPlan request);
    SubscriptionPlan toEntity(CreateSubscriptionPlanRequest request);

}
