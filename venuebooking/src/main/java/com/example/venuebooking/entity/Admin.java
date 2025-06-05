package com.example.venuebooking.entity;

import jakarta.persistence.*;
import lombok.Data;

// entity/Admin.java
@Data
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    // Getter/Setter
}
