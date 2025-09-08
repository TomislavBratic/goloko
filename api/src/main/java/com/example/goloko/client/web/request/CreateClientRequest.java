package com.example.goloko.client.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateClientRequest(
@NotNull Long userId,
@NotBlank @Size(max = 255) String businessName,
Long subscriptionPlanId,
@Size(max = 5000) String verificationText
) {
}
