package com.example.goloko.event.web;

import com.example.goloko.event.application.EventService;
import com.example.goloko.event.web.request.CreateEventRequest;
import com.example.goloko.event.web.response.CreateEventResponse;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/locations/{clientLocationId}/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateEventResponse> create(@PathVariable Long clientLocationId, @RequestBody CreateEventRequest request){
        CreateEventResponse saved = service.create(clientLocationId,request);

        return ResponseEntity.created(URI.create("/api/locations/" + clientLocationId + "/events/" + saved.id()))
                .body(saved);
    }
}
