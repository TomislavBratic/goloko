package com.example.goloko.payment.domain;

import com.example.goloko.client.domain.Client;
import com.example.goloko.subscription_plan.domain.SubscriptionPlan;
import com.example.goloko.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payments")
public class Payment {

    @Id
    @SequenceGenerator(name = "payments_seq", sequenceName = "payments_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "payments_seq")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_payments_user"))
    private User user;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_payments_client"))
    private Client client;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_plan_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_payments_subscription_plan"))
    private SubscriptionPlan subscriptionPlan;

    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public Status status;

    @Column(nullable = false,updatable = false)
    private Instant payment_date = Instant.now();

    @PrePersist
    void prePersist() {
        if (status == null) status = Status.PENDING;
    }
}
