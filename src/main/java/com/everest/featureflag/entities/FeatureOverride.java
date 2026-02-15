package com.everest.featureflag.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "overrides",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"featureKey", "scopeType", "scopeId"})
        }
)
public class FeatureOverride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String featureKey;

    private String scopeType;   // USER or GROUP

    private String scopeId;     // userId or groupId

    private boolean enabled;

    // getters and setters
}

