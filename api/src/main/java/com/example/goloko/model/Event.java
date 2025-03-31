package com.example.goloko.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "location", columnDefinition = "geometry(Point, 4326)")
    private Point location;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Event(Client client, String title, String description,
                 LocalDateTime eventDate, Point location, LocalDateTime createdAt){
        this.client = client;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.location = location;
        this.createdAt = createdAt;
    }

    public Event() {}

    private Event(Builder builder) {
        this.client = builder.client;
        this.title = builder.title;
        this.description = builder.description;
        this.eventDate = builder.eventDate;
        this.location = builder.location;
        this.createdAt = builder.createdAt;
    }

    public static class Builder {
        private Client client;
        private String title;
        private String description;
        private LocalDateTime eventDate;
        private Point location;
        private LocalDateTime createdAt;

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder eventDate(LocalDateTime eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Builder location(Point location) {
            this.location = location;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
