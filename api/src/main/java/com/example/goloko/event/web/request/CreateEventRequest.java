package com.example.goloko.event.web.request;

import java.time.LocalDateTime;

public record CreateEventRequest(
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
