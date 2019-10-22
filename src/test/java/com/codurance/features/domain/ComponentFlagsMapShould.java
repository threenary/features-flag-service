package com.codurance.features.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComponentFlagsMapShould {

    private static final String FEATURE = "feature";
    private static final String DEV = "dev";

    private ComponentFeaturesMap componentFeaturesMap;

    @BeforeEach
    void setUp() {
        componentFeaturesMap = new ComponentFeaturesMap();
    }

    @Test
    void
    add_a_new_environment_features_map() {
        EnvironmentFeaturesMap environmentFeaturesMap = buildEnvironmentMap();
        componentFeaturesMap.put(DEV, environmentFeaturesMap);

        assertEquals(environmentFeaturesMap, componentFeaturesMap.get(DEV));
    }

    @Test
    void
    return_null_if_environment_does_not_exist() {
        componentFeaturesMap.put(DEV, buildEnvironmentMap());
        assertNull(componentFeaturesMap.get("non_existing_environment"));
    }

    private EnvironmentFeaturesMap buildEnvironmentMap(){
        EnvironmentFeaturesMap map = new EnvironmentFeaturesMap();
        map.put(FEATURE, true);
        return map;
    }
}