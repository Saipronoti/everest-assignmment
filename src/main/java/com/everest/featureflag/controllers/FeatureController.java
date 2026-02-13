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

    @GetMapping
    public ResponseEntity<Map<String, Feature>> getAllFeatures() {
        return ResponseEntity.ok(featureStore);
    }

    @PutMapping("/{key}")
    public ResponseEntity<String> updateFeature(@PathVariable String key, @RequestBody Map<String, Object> updates) {
        if (!featureStore.containsKey(key)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feature with key '" + key + "' not found.");
        }

        Feature feature = featureStore.get(key);
        if (updates.containsKey("defaultEnabled")) {
            feature.setDefaultEnabled((Boolean) updates.get("defaultEnabled"));
        }

        return ResponseEntity.ok("Feature updated successfully.");
    }
}