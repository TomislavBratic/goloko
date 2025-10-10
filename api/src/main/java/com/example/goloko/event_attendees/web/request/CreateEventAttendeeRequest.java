package com.example.goloko.event_attendees.web.request;

import com.example.goloko.event_attendees.domain.Status;

public record CreateEventAttendeeRequest(
        Long userId,
        Status status
){
}
