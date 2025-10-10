package com.example.goloko.event_attendees.web.mapper;

import com.example.goloko.event_attendees.domain.EventAttendee;
import com.example.goloko.event_attendees.web.request.CreateEventAttendeeRequest;
import com.example.goloko.event_attendees.web.response.CreateEventAttendeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventAttendeeMapper {

    @Mapping(target = "user", ignore = true)
    EventAttendee toEntity(CreateEventAttendeeRequest ear);

    @Mapping(source = "user.id", target = "userId")
    CreateEventAttendeeResponse toResponse(EventAttendee ea);
}
