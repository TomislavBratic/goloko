package com.example.goloko.event_attendees.web;

import com.example.goloko.event_attendees.application.EventAttendeeService;
import com.example.goloko.event_attendees.web.request.CreateEventAttendeeRequest;
import com.example.goloko.event_attendees.web.response.CreateEventAttendeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/locations/{clientLocationId}/events/{eventId}/attendees")
public class EventAttendeeController {
    private EventAttendeeService service;

    public EventAttendeeController(EventAttendeeService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CreateEventAttendeeResponse> create(@PathVariable Long clientLocationId, @PathVariable Long eventId,@RequestBody CreateEventAttendeeRequest request){
        CreateEventAttendeeResponse saved = service.create(eventId, request);

        return ResponseEntity.created(URI.create("/api/locations/" + clientLocationId + "/events" + eventId + "/attendees"))
                .body(saved);
    }
}
