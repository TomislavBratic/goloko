package com.example.goloko.client.domain;
import com.example.goloko.subscription_plan.domain.SubscriptionPlan;
import com.example.goloko.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients", uniqueConstraints =@UniqueConstraint(name = "uq_client_user_id",columnNames = "user_id"))
public class Client {
    @Id
    @SequenceGenerator(name = "clients_seq", sequenceName = "clients_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "clients_seq")
    @EqualsAndHashCode.Include
    public Long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",nullable = false,
    foreignKey = @ForeignKey(name = "fk_clients_user"))
    public User user;
    @Column(nullable = false,name = "business_name",length = 255)
    @ToString.Include
    public String businessName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "subscription_status", length = 20)
    public SubscriptionStatus subscriptionStatus = SubscriptionStatus.PENDING;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "verification_status", length = 20)
    public VerificationStatus verificationStatus = VerificationStatus.PENDING;
    @Lob
    @Column(name = "verification_notes", columnDefinition = "TEXT")
    public String verificationText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_plan_id",nullable = false,
    foreignKey = @ForeignKey(name = "fk_clients_subscription_plan"))
    public SubscriptionPlan subscriptionPlan;
    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();
}
