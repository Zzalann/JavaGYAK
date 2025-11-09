package com.example.f1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;

    @Column(length = 2000)
    private String uzenet;
}
