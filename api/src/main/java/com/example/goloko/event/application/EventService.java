package com.example.goloko.event.application;

import com.example.goloko.client_location.domain.ClientLocation;
import com.example.goloko.client_location.domain.ClientLocationRepository;
import com.example.goloko.event.domain.Event;
import com.example.goloko.event.web.mapper.EventMapper;
import com.example.goloko.event.web.request.CreateEventRequest;
import com.example.goloko.event.web.response.CreateEventResponse;
import com.example.goloko.event.domain.EventRepository;
import com.example.goloko.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository repository;
    private final ClientLocationRepository clientLocationRepository;
    private final EventMapper mapper;

    public EventService(EventRepository repository, ClientLocationRepository clientLocationRepository,
                        EventMapper mapper)
    {
        this.repository = repository;
        this.clientLocationRepository = clientLocationRepository;
        this.mapper = mapper;
    }

    public CreateEventResponse create(Long clientLocationId, CreateEventRequest request) {

        ClientLocation clientLocation = clientLocationRepository.findById(clientLocationId).orElseThrow(() -> new NotFoundException("Client location not found"));

        Event event = mapper.toEntity(request);
        event.setLocation(clientLocation.getCoordinates());
        event.setClientLocation(clientLocation);

        repository.save(event);
        return mapper.toResponse(event);
    }
}
