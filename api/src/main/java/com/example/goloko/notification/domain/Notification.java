package com.example.goloko.notification.domain;

import com.example.goloko.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="notifications")
public class Notification {

    @Id
    @SequenceGenerator(name = "notifications_seq", sequenceName = "notifications_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "notifications_seq")
    @EqualsAndHashCode.Include
    public Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_notifications_user"))
    public User user;

    @Lob
    @Column(columnDefinition = "TEXT")
    public String message;

    @Column(nullable = false)
    boolean isRead = false;

    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();
}
