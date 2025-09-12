package com.example.goloko.subscriptionplan.domain;

import com.example.goloko.client.domain.Client;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @OneToMany(mappedBy = "subscriptionPlan",fetch = FetchType.LAZY)
    private Set<Client> client = new HashSet<>();
    @Column(name = "name",length = 255,nullable = false)
    @ToString.Include
    private String name;
    @Column(name = "max_locations",nullable = false)
    private Integer maxLocations;
    @Column(name="price", nullable = false,precision = 10,scale = 2)
    private BigDecimal price;
    @Column(name = "duration_months", nullable = false)
    private Integer durationMonths = 1;
    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();


    @PrePersist
    void prePersist() {
        if (createdAt == null) createdAt = Instant.now();
        if (durationMonths == null) durationMonths = 1;
    }
}
