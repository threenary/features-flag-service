package com.codurance.features.domain;

import java.util.HashMap;
import java.util.Map;

public class ComponentFeaturesMap {

    private Map<String, EnvironmentFeaturesMap> componentEnvironmentsMap = new HashMap<>();

    public EnvironmentFeaturesMap get(String environment) {
        return componentEnvironmentsMap.get(environment);
    }

    public void put(String environment, EnvironmentFeaturesMap environmentMap) {
        this.componentEnvironmentsMap.put(environment, environmentMap);
    }

    public boolean getFeature(String environment, String feature) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }
}
