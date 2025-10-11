package com.example.goloko.admin_setting.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin_settings")
public class AdminSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    public Long id;

    @Column( nullable = false,length = 255)
    public String settingKey;

    @Lob
    @Column( columnDefinition = "TEXT")
    public String settingValue;

    @Column(nullable = false,updatable = false)
    private Instant updatedAt = Instant.now();
}
