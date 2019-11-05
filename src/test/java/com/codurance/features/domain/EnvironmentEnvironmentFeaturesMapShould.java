package com.codurance.features.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentEnvironmentFeaturesMapShould {

    private static final String FEATURE = "feature";
    private static final String NON_EXISTING_FEATURE = "non_existing_feature";

    private EnvironmentFeaturesMap environmentFeaturesMap;

    @BeforeEach
    void setUp() {
        environmentFeaturesMap = new EnvironmentFeaturesMap(
                new HashMap<String, Boolean>() {{
                    put(FEATURE, true);
                }}
        );
    }

    @Test
    void
    add_feature_flag_for_given_component() {
        assertTrue(environmentFeaturesMap.get(FEATURE));
    }

    @Test
    void
    return_false_when_the_feature_does_not_exist() {
        assertFalse(environmentFeaturesMap.get(NON_EXISTING_FEATURE));
    }
}
