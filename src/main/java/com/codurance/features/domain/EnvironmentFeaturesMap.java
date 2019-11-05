package com.codurance.features.domain;

import java.util.Map;

public class EnvironmentFeaturesMap {

    private Map<String, Boolean> featuresMap;

    public EnvironmentFeaturesMap(Map<String, Boolean> featuresMap) {
        this.featuresMap = featuresMap;
    }

    public boolean get(String feature) {
        return (null != featuresMap.get(feature))
                ? featuresMap.get(feature)
                : false;
    }

    public void put(String feature, boolean value) {
        featuresMap.put(feature, value);
    }

}
