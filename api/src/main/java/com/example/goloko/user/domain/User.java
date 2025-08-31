package com.example.goloko.user.domain;

import com.example.goloko.client.domain.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints =@UniqueConstraint(name = "uq_users_email",columnNames = "email"))
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // for MariaDB insertion is Identity, that means hibernate doesn't know id before insertion, opposite of Sequence
    private Long id;
    @Column(nullable = false,length = 255)
    private String email;
    @Column(name = "password_hash", nullable = false,length = 255)
    private String passwordHash;
    @Column(name="first_name", nullable = false,length = 100)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Enumerated(EnumType.STRING) //we must put string to use names of enums, not ordinal numbers, since enums are counted array of constants
    @Column(nullable = false,length = 20)
    private Role role = Role.USER;
    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt = Instant.now();

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Client client;

}
