package com.example.goloko.model;

import com.example.goloko.enums.AttendeeStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_attendees")
public class EventAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name =  "status")
    private AttendeeStatus attendeeStatus;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    public EventAttendee(Event event, User user, AttendeeStatus attendeeStatus, LocalDateTime registeredAt){
        this.event=event;
        this.user=user;
        this.attendeeStatus=attendeeStatus;
        this.registeredAt=registeredAt;
    }

    public EventAttendee() {}

    private EventAttendee(Builder builder) {
        this.event = builder.event;
        this.user = builder.user;
        this.attendeeStatus = builder.attendeeStatus;
        this.registeredAt = builder.registeredAt;
    }

    public static class Builder {
        private Event event;
        private User user;
        private AttendeeStatus attendeeStatus;
        private LocalDateTime registeredAt;

        public Builder event(Event event) {
            this.event = event;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder attendeeStatus(AttendeeStatus attendeeStatus) {
            this.attendeeStatus = attendeeStatus;
            return this;
        }

        public Builder registeredAt(LocalDateTime registeredAt) {
            this.registeredAt = registeredAt;
            return this;
        }

        public EventAttendee build() {
            return new EventAttendee(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AttendeeStatus getAttendeeStatus() {
        return attendeeStatus;
    }

    public void setAttendeeStatus(AttendeeStatus attendeeStatus) {
        this.attendeeStatus = attendeeStatus;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
