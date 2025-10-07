package com.example.goloko.event.web.mapper;

import com.example.goloko.event.domain.Event;
import com.example.goloko.event.web.request.CreateEventRequest;
import com.example.goloko.event.web.response.CreateEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {
    @Mapping(target = "clientLocation", ignore = true)
    @Mapping(target = "location", ignore = true)
    Event toEntity(CreateEventRequest request);

    CreateEventResponse toResponse(Event event);
}
