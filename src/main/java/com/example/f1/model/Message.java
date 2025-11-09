package com.example.f1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String name;
    @Email @NotBlank private String email;
    @NotBlank @Size(min=5) private String text;
    private LocalDateTime createdAt = LocalDateTime.now();

}
