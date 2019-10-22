package com.codurance.features.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentFeaturesMapShould {

    private static final String FEATURE = "feature";
    private static final String NON_EXISTING_FEATURE = "non_existing_feature";

    @Test
    void
    add_feature_flag_for_given_component() {
        EnvironmentFeaturesMap environmentFeaturesMap = new EnvironmentFeaturesMap();
        environmentFeaturesMap.put(FEATURE, true);

        assertTrue(environmentFeaturesMap.get(FEATURE));
    }

    @Test
    void
    return_false_when_the_feature_does_not_exist() {
        EnvironmentFeaturesMap environmentFeaturesMap = new EnvironmentFeaturesMap();
        environmentFeaturesMap.put(FEATURE, true);

        assertFalse(environmentFeaturesMap.get(NON_EXISTING_FEATURE));
    }

    private EnvironmentFeaturesMap buildEnvironmentMap() {
        EnvironmentFeaturesMap environmentFeaturesMap = new EnvironmentFeaturesMap();
        environmentFeaturesMap.put(FEATURE, true);
        return environmentFeaturesMap;
    }
}
