package com.example.goloko.payment.web.mapper;

import com.example.goloko.payment.domain.Payment;
import com.example.goloko.payment.web.request.CreatePaymentRequest;
import com.example.goloko.payment.web.response.CreatePaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "subscriptionPlan", ignore = true)
    Payment toEntity(CreatePaymentRequest cpr);

    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "client.businessName", target = "businessName")
    @Mapping(source = "subscriptionPlan.name", target = "subscriptionPlanName")
    CreatePaymentResponse toResponse(Payment payment);

}
