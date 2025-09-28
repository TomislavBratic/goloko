package com.example.goloko.client_location.web.request;

import com.example.goloko.client_location.domain.CoordinatesDTO;

import java.awt.*;

public record CreateClientLocationRequest(
        String name,
        CoordinatesDTO coordinates,
        String formattedAddr,
        String placeId,
        String addressText,
        String verificationNotes
){}
