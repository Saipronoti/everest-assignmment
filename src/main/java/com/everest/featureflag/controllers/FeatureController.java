package com.everest.featureflag.controllers;

import com.everest.featureflag.entities.Feature;
import com.everest.featureflag.models.FeatureRequest;
import com.everest.featureflag.repository.FeatureRepository;
import com.everest.featureflag.responses.FeatureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeatureController {

   // private final Map<String, Feature> featureStore = new HashMap<>();
   @Autowired
   private FeatureRepository featureRepository;

    @PostMapping
    public ResponseEntity<FeatureResponse> createFeature(@RequestBody FeatureRequest feature) {
        if (featureRepository.findById(feature.getKey()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new FeatureResponse("Feature with key '" + feature.getKey() + "' already exists.", HttpStatus.CONFLICT.value()));
        }
        Feature entityFeature = convertToEntity(feature);
        featureRepository.save(entityFeature);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new FeatureResponse("Feature created successfully.", HttpStatus.CREATED.value()));
    }

    @GetMapping
    public ResponseEntity<List<Feature>> getAllFeatures() {
        return ResponseEntity.ok(featureRepository.findAll());
    }

    private Feature convertToEntity(FeatureRequest feature) {
        Feature entityFeature = new Feature();
        entityFeature.setKey(feature.getKey());
        entityFeature.setDefaultEnabled(feature.isDefaultEnabled());
        entityFeature.setDescription(feature.getDescription());
        return entityFeature;
    }

    @PutMapping("/{key}")
    public ResponseEntity<FeatureResponse> updateFeature(@PathVariable String key, @RequestBody FeatureRequest updates) {
        return featureRepository.findById(key).map(feature -> {
            feature.setDefaultEnabled(updates.isDefaultEnabled());
            featureRepository.save(feature);
            return ResponseEntity.ok(new FeatureResponse("Feature updated successfully.", HttpStatus.OK.value()));
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new FeatureResponse("Feature with key '" + key + "' not found.", HttpStatus.NOT_FOUND.value())));
    }
}