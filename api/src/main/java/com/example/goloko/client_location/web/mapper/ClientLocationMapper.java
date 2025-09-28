package com.example.goloko.client_location.web.mapper;

import com.example.goloko.client_location.domain.ClientLocation;
import com.example.goloko.client_location.domain.CoordinatesDTO;
import com.example.goloko.client_location.web.request.CreateClientLocationRequest;
import com.example.goloko.client_location.web.response.CreateClientLocationResponse;
import org.locationtech.jts.geom.Point;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientLocationMapper {

    @Mapping(target = "coordinates", ignore = true)
    @Mapping(target = "client",ignore = true)
    ClientLocation toEntity(CreateClientLocationRequest cl);


    @Mapping(target = "coordinates", source = "coordinates")
    @Mapping(target = "clientId", source = "client.id")
    CreateClientLocationResponse toResponse(ClientLocation cl);

    default CoordinatesDTO map(Point point) {
        if (point == null) return null;
        return new CoordinatesDTO(point.getX(), point.getY());
    }

}
