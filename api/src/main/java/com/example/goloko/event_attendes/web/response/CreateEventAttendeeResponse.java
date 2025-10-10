package com.example.goloko.event_attendes.web.response;

import com.example.goloko.event_attendes.domain.Status;

public record CreateEventAttendeeResponse(
        Long userId,
        Status status
) {
}
