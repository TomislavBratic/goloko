package com.example.goloko.client_location.domain;
import com.example.goloko.client.domain.Client;
import com.example.goloko.event.domain.Event;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Point;

import java.awt.*;
import java.time.Instant;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_locations")
public class ClientLocation {
    @Id
    @SequenceGenerator(name = "client_locations_seq", sequenceName = "client_locations_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "client_locations_seq")
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_client_locations_client"))
    private Client client;
    @ToString.Include
    @Column(nullable = false,name = "name",length = 255)
    private String name;
    @JdbcTypeCode(SqlTypes.GEOMETRY)
    @Column(name = "coordinates", nullable = false, columnDefinition = "geometry(Point, 4326)")
    private Point coordinates;
    @Column(name = "formatted_addr", length = 500)
    private String formattedAddr;
    @Column(name = "place_id", length = 255) //optional id
    private String placeId;
    @Lob
    @Column(name = "address_text",columnDefinition = "TEXT")
    private String addressText;
    @Column(name = "is_verified",nullable = false)
    boolean isVerified = false;
    @Lob
    @Column(name = "verification_notes", columnDefinition = "TEXT")
    public String verificationNotes;
    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();

    /*@OneToMany(mappedBy = "clientLocation",fetch = FetchType.LAZY)
    private Set<Event> events;*/
}
