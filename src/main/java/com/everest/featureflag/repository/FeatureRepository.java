package com.everest.featureflag.repository;

import com.everest.featureflag.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, String> {
    // Example of a valid query method
    Feature findByKey(String key);
}