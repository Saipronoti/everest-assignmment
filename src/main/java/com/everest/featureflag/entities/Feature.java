package com.everest.featureflag.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String featureKey;

    private boolean defaultEnabled;

    private String description;

    // getters and setters
}

