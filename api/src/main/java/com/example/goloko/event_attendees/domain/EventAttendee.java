package com.example.goloko.event_attendees.domain;

import com.example.goloko.event.domain.Event;
import com.example.goloko.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="event_attendees")
public class EventAttendee {
    @Id
    @SequenceGenerator(name = "event_attendees_seq", sequenceName = "event_attendees_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "event_attendees_seq")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_event_attendees_event"))
    private Event event;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_event_attendees_user"))
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status;

    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();
}
