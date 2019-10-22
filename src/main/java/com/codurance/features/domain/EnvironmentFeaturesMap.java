package com.codurance.features.domain;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentFeaturesMap {

    private Map<String, Boolean> environmentFeaturesMap = new HashMap<>();

    public boolean get(String feature) {
        return (null != environmentFeaturesMap.get(feature))
                ? environmentFeaturesMap.get(feature)
                : false;
    }

    public void put(String feature, boolean value) {
        environmentFeaturesMap.put(feature, value);
    }

    public void setEnvironmentFeaturesMap(Map<String, Boolean> environmentFeaturesMap){
        this.environmentFeaturesMap = environmentFeaturesMap;
    }
}
