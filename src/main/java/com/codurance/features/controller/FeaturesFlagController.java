package com.codurance.features.controller;

import com.codurance.features.service.FeaturesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeaturesFlagController {

    private final FeaturesService featureService;

    public FeaturesFlagController(FeaturesService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("/{component}/{feature}")
    public boolean getFeature(@PathVariable String component, @PathVariable String feature) {
        return featureService.getFeatureForComponent(component, feature);
    }
}
