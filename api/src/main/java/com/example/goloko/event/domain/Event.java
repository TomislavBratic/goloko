package com.example.goloko.event.domain;

import com.example.goloko.client_location.domain.ClientLocation;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="events")
public class Event {
    @Id
    @SequenceGenerator(name = "events_seq", sequenceName = "events_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "events_seq")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_location_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_events_client_location"))
    private ClientLocation clientLocation;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private LocalDateTime startTime;

     @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false, columnDefinition = "geometry(Point, 4326)")
    private Point location;

    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();
}
