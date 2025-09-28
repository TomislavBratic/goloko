package com.example.goloko.client_location.application;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client.domain.ClientRepository;
import com.example.goloko.client_location.domain.ClientLocation;
import com.example.goloko.client_location.web.mapper.ClientLocationMapper;
import com.example.goloko.client_location.web.request.CreateClientLocationRequest;
import com.example.goloko.client_location.web.response.CreateClientLocationResponse;
import com.example.goloko.client_location.domain.ClientLocationRepository;
import com.example.goloko.exceptions.NotFoundException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientLocationService {

    private final ClientLocationRepository repository;
    private final ClientLocationMapper mapper;
    private final ClientRepository clientRepository;
    private final GeometryFactory geometryFactory;

    public ClientLocationService(ClientLocationRepository repository,ClientRepository clientRepository,
                                 ClientLocationMapper mapper, GeometryFactory geometryFactory){
        this.repository = repository;
        this.mapper = mapper;
        this.clientRepository = clientRepository;
        this.geometryFactory = geometryFactory;
    }
    @Transactional
    public CreateClientLocationResponse create(Long clientId, CreateClientLocationRequest request){

        Client client = clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException("client not found"));

        ClientLocation clientLocation = mapper.toEntity(request);
        Point point = geometryFactory.createPoint(new Coordinate(
                request.coordinates().x(),
                request.coordinates().y()));

        point.setSRID(4326);
        clientLocation.setCoordinates(point);

        clientLocation.setClient(client);
        repository.save(clientLocation);

        return mapper.toResponse(clientLocation);
    }
}
