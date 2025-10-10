package com.example.goloko.event_attendes.web.request;

import com.example.goloko.event_attendes.domain.Status;

public record CreateEventAttendeeRequest(
        Long userId,
        Status status
){
}
