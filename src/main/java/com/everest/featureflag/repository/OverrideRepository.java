package com.everest.featureflag.repository;

import com.everest.featureflag.entities.FeatureOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OverrideRepository
        extends JpaRepository<FeatureOverride, Long> {

    Optional<FeatureOverride>
    findByFeatureKeyAndScopeTypeAndScopeId(
            String featureKey,
            String scopeType,
            String scopeId
    );
}

