package com.example.goloko.event_attendes.web.mapper;

import com.example.goloko.event_attendes.domain.EventAttendee;
import com.example.goloko.event_attendes.web.request.CreateEventAttendeeRequest;
import com.example.goloko.event_attendes.web.response.CreateEventAttendeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventAttendeeMapper {

    @Mapping(target = "user", ignore = true)
    EventAttendee toEntity(CreateEventAttendeeRequest ear);

    @Mapping(source = "user.id", target = "userId")
    CreateEventAttendeeResponse toResponse(EventAttendee ea);
}
