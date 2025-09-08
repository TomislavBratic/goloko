package com.example.goloko.subscriptionplan.web.mapper;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import com.example.goloko.subscriptionplan.web.request.CreateSubscriptionPlanRequest;
import com.example.goloko.subscriptionplan.web.response.SubscriptionPlanResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SubscriptionPlanMapper {
    SubscriptionPlanResponse toSubscriptionPlanResponse(SubscriptionPlan request);
    SubscriptionPlan toEntity(CreateSubscriptionPlanRequest request);

}
