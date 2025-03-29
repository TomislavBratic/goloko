package com.example.goloko.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Transient
    private String password;

    private String hashedPassword;


    @Enumerated(EnumType.STRING)


}
