package com.example.goloko.client_location.web.response;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client_location.domain.CoordinatesDTO;
import org.locationtech.jts.geom.Point;

import java.awt.*;

public record CreateClientLocationResponse(
        Long id,
        String name,
        Long clientId,
        CoordinatesDTO coordinates,
        String formattedAddr,
        String placeId,
        String addressText,
        String verificationNotes
) {
}
