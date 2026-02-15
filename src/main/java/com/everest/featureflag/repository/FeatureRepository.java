package com.everest.featureflag.repository;

import com.everest.featureflag.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FeatureRepository
        extends JpaRepository<Feature, Long> {

    Optional<Feature> findByFeatureKey(String featureKey);
}

