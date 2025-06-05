package com.example.venuebooking.entity;

import jakarta.persistence.*;
import lombok.Data;

// entity/User.java
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    // Getter/Setter
}
