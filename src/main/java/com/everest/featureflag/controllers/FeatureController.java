package com.everest.featureflag.controllers;

import com.everest.featureflag.models.Feature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final Map<String, Feature> featureStore = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> createFeature(@RequestBody Feature feature) {
        if (featureStore.containsKey(feature.getKey())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Feature with key '" + feature.getKey() + "' already exists.");
        }
        featureStore.put(feature.getKey(), feature);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Feature created successfully.");
    }
}