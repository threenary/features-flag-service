package com.codurance.features.config;

import com.codurance.features.domain.ComponentFeaturesMap;
import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigReaderShould {

    private static final String TEST_FEATURES_YML = "test-features.yml";
    private static final String APPLICATION = "application";
    private static final String ENVIRONMENT = "development";
    private static final String EXISTING_FEATURE = "feature1";
    private static final String NON_EXISTING_FEATURE = "featureXXX";

    @Test
    void
    read_flag_value_for_give_application_in_given_environment() {
        ConfigReader reader = new ConfigReader();

        Map<String, ComponentFeaturesMap> features = reader.loadFeaturesFile(TEST_FEATURES_YML);

        ComponentFeaturesMap component = features.get(APPLICATION);
        assertNotNull(component);

        EnvironmentFeaturesMap environment = component.get(ENVIRONMENT);

        assertNotNull(environment);
        assertTrue(environment.get(EXISTING_FEATURE));
        assertFalse(environment.get(NON_EXISTING_FEATURE));
    }
}
