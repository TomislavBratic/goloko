package com.example.goloko.event_attendees.web.response;

import com.example.goloko.event_attendees.domain.Status;

public record CreateEventAttendeeResponse(
        Long userId,
        Status status
) {
}
