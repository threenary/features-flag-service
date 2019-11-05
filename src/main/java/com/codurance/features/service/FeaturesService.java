package com.codurance.features.service;

import org.springframework.stereotype.Service;

@Service
public class FeaturesService {

    private final FeaturesRepository reader;

    public FeaturesService(FeaturesRepository reader) {
        this.reader = reader;
    }

    public boolean getFeatureFlagValue(String feature) {
        return (null != reader.getFeatureFlagValue(feature))
                && reader.getFeatureFlagValue(feature);
    }
}
