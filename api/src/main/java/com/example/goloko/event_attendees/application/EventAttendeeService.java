package com.example.goloko.event_attendees.application;


import com.example.goloko.event.domain.Event;
import com.example.goloko.event.domain.EventRepository;
import com.example.goloko.event_attendees.domain.EventAttendee;
import com.example.goloko.event_attendees.domain.EventAttendeeRepository;
import com.example.goloko.event_attendees.web.mapper.EventAttendeeMapper;
import com.example.goloko.event_attendees.web.request.CreateEventAttendeeRequest;
import com.example.goloko.event_attendees.web.response.CreateEventAttendeeResponse;
import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EventAttendeeService {

    private final EventAttendeeRepository repository;
    private final EventAttendeeMapper mapper;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventAttendeeService(EventAttendeeRepository repository, EventAttendeeMapper mapper,
                                EventRepository eventRepository, UserRepository userRepository){

        this.repository = repository;
        this.mapper = mapper;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }
    public CreateEventAttendeeResponse create(Long eventId, CreateEventAttendeeRequest request)
    {
        User user = userRepository.findById(request.userId()).orElseThrow(()-> new NotFoundException("User not found"));
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new NotFoundException("Event not found"));

        EventAttendee eventAttendee = mapper.toEntity(request);
        eventAttendee.setEvent(event);
        eventAttendee.setUser(user);

        repository.save(eventAttendee);

        return mapper.toResponse(eventAttendee);
    }
}
