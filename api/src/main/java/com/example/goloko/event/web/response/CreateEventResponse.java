package com.example.goloko.event.web.response;

import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public record CreateEventResponse(
        Long id,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime
) {

}
