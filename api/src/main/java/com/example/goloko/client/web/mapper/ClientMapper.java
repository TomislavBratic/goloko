package com.example.goloko.client.web.mapper;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client.web.request.CreateClientRequest;
import com.example.goloko.client.web.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "businessName",source = "businessName")
    @Mapping(target = "verificationText", source = "verificationText")
    @Mapping(target = "subscriptionPlanName", source = "subscriptionPlan.name")
    @Mapping(target = "maxLocations", source = "subscriptionPlan.maxLocations")
    @Mapping(target = "subscriptionDuration", source = "subscriptionPlan.durationMonths")
    @Mapping(target = "subscriptionPrice", source = "subscriptionPlan.price")
    ClientResponse getClient(Client c);

    @Mapping(target = "subscriptionPlan", ignore = true) // handled manually
    @Mapping(target = "user", ignore = true)
    Client toEntity(CreateClientRequest request);

}
