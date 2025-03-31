package com.example.goloko.model;

import jakarta.persistence.*;
import com.example.goloko.enums.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Transient
    private String password;

    @Column(name="password_hash")
    private String hashedPassword;

    @Transient
    private String name;

    @Transient
    private String surname;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User(String password, String name, String surname, Role role, LocalDateTime createdAt){
        this.password = password;

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.hashedPassword=passwordEncoder.encode(password);

        this.name = name;
        this.surname = surname;
        this.fullName = name + " " + surname;

        this.role = role;
        this.createdAt=createdAt;

    }

    private User(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.hashedPassword = builder.hashedPassword;
        this.name = builder.name;
        this.surname = builder.surname;
        this.fullName = builder.name + " " + builder.surname;
        this.role = builder.role;
        this.createdAt = builder.createdAt;
    }

    public static class Builder {
        private Long id;
        private String password;
        private String hashedPassword;
        private String name;
        private String surname;
        private Role role;
        private LocalDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder hashedPassword(String hashedPassword) {
            this.hashedPassword = hashedPassword;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFullName() {
        this.fullName = this.name + this.surname;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
