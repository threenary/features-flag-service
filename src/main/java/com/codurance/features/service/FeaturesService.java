package com.codurance.features.service;

import com.codurance.features.domain.ComponentFeaturesMap;
import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.springframework.stereotype.Service;

@Service
public class FeaturesService {

    private final FeaturesRepository reader;

    public FeaturesService(FeaturesRepository reader) {
        this.reader = reader;
    }

    public boolean getFeatureForComponent(String component, String feature) {
        return (null != reader.getFeaturesForComponent(component))
                && reader.getFeaturesForComponent(component).get(feature);
    }
}
