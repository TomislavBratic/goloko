package com.example.goloko.event_attendes.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAttendeeRepository extends JpaRepository<EventAttendee, Long> {
}
