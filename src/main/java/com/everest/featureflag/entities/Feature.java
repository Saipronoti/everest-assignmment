package com.everest.featureflag.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "features")
public class Feature {

    @Id
    @Column(name = "feature_key")
    private String key; // Ensure this is a String
    @Column(name = "default_enabled", nullable = false)
    private boolean defaultEnabled;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isDefaultEnabled() {
        return defaultEnabled;
    }

    public void setDefaultEnabled(boolean defaultEnabled) {
        this.defaultEnabled = defaultEnabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;



    // getters and setters
}

